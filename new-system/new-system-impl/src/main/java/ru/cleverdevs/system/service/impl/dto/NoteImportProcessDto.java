package ru.cleverdevs.system.service.impl.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cleverdevs.system.dto.deprecated.ClientDto;
import ru.cleverdevs.system.dto.deprecated.NoteDto;
import ru.cleverdevs.system.model.CompanyUser;
import ru.cleverdevs.system.model.PatientNote;
import ru.cleverdevs.system.model.PatientProfile;

/**
 * Класс для процесса импорта заметок
 *
 * <p>
 * Содержит информацию о клиентах, сопоставлениях между клиентами и пациентами,
 * а также о заметках и статистике процесса импорта
 * </p>
 *
 * @author Pavel Zhykhar
 */
@Data
@NoArgsConstructor
public class NoteImportProcessDto {

    /**
     * Список клиентов, полученных из старой системы
     */
    private List<ClientDto> clients;

    /**
     * Сопоставление клиентов и пациентов, где ключ - GUID клиента
     * значение - соответствующий пациент в новой системе
     */
    private Map<String, PatientProfile> clientToPatientMapping;

    /**
     * Сопоставление логинов пользователей, где ключ - логин пользователя
     * значение - соответствующий пользователь в новой системе
     */
    private Map<String, CompanyUser> userMapping;

    /**
     * Карта заметок по каждому клиенту, ключ - GUID клиента,
     * значение - список заметок для этого клиента
     */
    private Map<String, List<NoteDto>> notesByClient;

    /**
     * Карта с заметками, уже сохраненными в новой системе для возможности обновления
     */
    private Map<String, PatientNote> existingNotes;

    /**
     * Дата начала периода для выборки заметок
     */
    private LocalDate dateFrom = LocalDate.parse("2019-09-18");

    /**
     * Дата окончания периода для выборки заметок
     */
    private LocalDate dateTo = LocalDate.parse("2021-09-17");

    /**
     * Статистика об обработанных заметках
     */
    private int importedNotesCount = 0;

    /**
     * Статистика об обновленных заметках
     */
    private int updatedNotesCount = 0;

    /**
     * Ошибки, возникшие в процессе импорта, для логирования и отладки
     */
    private List<String> errorMessages;

    /**
     * Вспомогательный метод для обновления счетчика импортированных заметок
     */
    public void incrementImportedNotesCount() {
        this.importedNotesCount++;
    }

    /**
     * Вспомогательный метод для обновления счетчика обновленных заметок
     */
    public void incrementUpdatedNotesCount() {
        this.updatedNotesCount++;
    }
}
