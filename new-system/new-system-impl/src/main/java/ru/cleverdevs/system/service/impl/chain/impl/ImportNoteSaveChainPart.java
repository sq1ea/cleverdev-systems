package ru.cleverdevs.system.service.impl.chain.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.cleverdevs.system.dto.deprecated.NoteDto;
import ru.cleverdevs.system.model.CompanyUser;
import ru.cleverdevs.system.model.PatientNote;
import ru.cleverdevs.system.model.PatientProfile;
import ru.cleverdevs.system.repository.PatientNoteRepository;
import ru.cleverdevs.system.service.impl.chain.NoteImportChainPart;
import ru.cleverdevs.system.service.impl.dto.NoteImportProcessDto;

/**
 * Часть цепочки импорта, отвечающая за сохранение заметок в новой системе
 *
 * @author Pavel Zhykhar
 */
@Order(5)
@Component
@RequiredArgsConstructor
public class ImportNoteSaveChainPart implements NoteImportChainPart {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportNoteSaveChainPart.class);

    private final PatientNoteRepository repository;

    /**
     * Обрабатывает процесс сохранения или обновления заметок в новой системе
     *
     * <p>Для каждой заметки проверяет, существует ли она. Если да, обновляет; если нет, создаёт новую заметку </p>
     *
     * @param dto объект для хранения данных импорта
     * @return обновленный объект {@link NoteImportProcessDto}
     */
    public NoteImportProcessDto process(NoteImportProcessDto dto) {
        for (Map.Entry<String, List<NoteDto>> entry : dto.getNotesByClient().entrySet()) {
            String clientGuid = entry.getKey();
            PatientProfile patient = dto.getClientToPatientMapping().get(clientGuid);
            List<NoteDto> notes = entry.getValue();

            for (NoteDto noteDto : notes) {
                try {
                    String loggedUser = noteDto.getLoggedUser();

                    CompanyUser user = dto.getUserMapping().get(loggedUser);

                    LOGGER.debug("Обрабатываем заметку для клиента {}: NoteDto={}, PatientProfile={}, CompanyUser={}",
                        clientGuid, noteDto, patient, user);

                    if (patient == null || user == null) {
                        LOGGER.warn("Пропущена заметка для клиента {} из-за отсутствия обязательных данных: NoteDto={}, PatientProfile={}, CompanyUser={}",
                            clientGuid, noteDto, patient, user);
                        continue;
                    }

                    PatientNote note = convertToPatientNote(noteDto, patient, user);

                    saveOrUpdateNote(note);
                } catch (Exception e) {
                    LOGGER.error("Ошибка при обработке заметки для клиента {}: {}", clientGuid, e.getMessage(), e);
                }
            }
        }
        return dto;
    }

    /**
     * Преобразует {@link NoteDto} в {@link PatientNote}
     *
     * @param noteDto объект передачи данных, содержащий информацию о заметке
     * @param patient профиль пациента, связанный с заметкой
     * @param user пользователь, создающий или изменяющий заметку
     * @return новый экземпляр {@link PatientNote}, заполненный предоставленными данными
     */
    private PatientNote convertToPatientNote(NoteDto noteDto, PatientProfile patient, CompanyUser user) {
        PatientNote note = new PatientNote();
        note.setCreatedDateTime(LocalDateTime.now());
        note.setLastModifiedDateTime(LocalDateTime.now());
        note.setCreatedBy(user);
        note.setLastModifiedBy(user);
        note.setPatient(patient);
        note.setNote(noteDto.getComments());

        return repository.save(note);
    }

    /**
     * Сохраняет {@link PatientNote} в репозитории или обновляет существующую заметку, если она уже существует
     *
     * @param note заметка, которую нужно сохранить или обновить
     * @throws RuntimeException если заметка не найдена при обновлении или если возникла ошибка во время сохранения
     */
    private void saveOrUpdateNote(PatientNote note) {
        try {
            if (note.getId() != null) {
                PatientNote existingNote = repository.findById(note.getId())
                    .orElseThrow(() -> new RuntimeException("Note not found with id: " + note.getId()));

                existingNote.setNote(note.getNote());
                existingNote.setLastModifiedDateTime(LocalDateTime.now());
                repository.save(existingNote);
            } else {
                repository.save(note);
            }
        } catch (Exception e) {
            LOGGER.error("Error saving or updating note: {}", e.getMessage(), e);
            throw e;
        }
    }
}
