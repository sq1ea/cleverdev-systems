package ru.cleverdevs.system.service.impl.chain.impl;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.cleverdevs.system.dto.deprecated.ClientDto;
import ru.cleverdevs.system.model.PatientProfile;
import ru.cleverdevs.system.repository.PatientProfileRepository;
import ru.cleverdevs.system.service.impl.chain.NoteImportChainPart;
import ru.cleverdevs.system.service.impl.dto.NoteImportProcessDto;

/**
 * Часть цепочки импорта, отвечающая за сопоставление клиентов с пациентами
 *
 * @author Pavel Zhykhar
 */
@Order(2)
@Component
@RequiredArgsConstructor
public class ImportPatientMappingChainPart implements NoteImportChainPart {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportPatientMappingChainPart.class);

    private final PatientProfileRepository repository;

    /**
     * Обрабатывает процесс сопоставления клиентов с пациентами
     *
     * <p>Ищет пациентов по старым идентификаторам клиентов и сохраняет соответствия в {@link NoteImportProcessDto} </p>
     *
     * @param noteImportProcessDto объект для хранения данных импорта
     * @return обновленный объект {@link NoteImportProcessDto} с сопоставлением клиентов и пациентов
     */
    @Override
    public NoteImportProcessDto process(NoteImportProcessDto noteImportProcessDto) {
        LOGGER.info("ImportPatientMappingChainPart process started");
        Map<String, PatientProfile> mappedPatients = new HashMap<>();

        if (noteImportProcessDto.getClients() == null) {
            LOGGER.error("Client list is null");
            return noteImportProcessDto;
        }

        for (ClientDto client : noteImportProcessDto.getClients()) {
            LOGGER.info("Processing client: {}", client);
            PatientProfile patient = repository.findByOldClientGuid(
                String.valueOf(client.getGuid()));
            if (patient != null) {
                mappedPatients.put(String.valueOf(client.getGuid()), patient);
            }
        }
        LOGGER.info("ImportPatientMappingChainPart finished");
        noteImportProcessDto.setClientToPatientMapping(mappedPatients);
        return noteImportProcessDto;
    }
}
