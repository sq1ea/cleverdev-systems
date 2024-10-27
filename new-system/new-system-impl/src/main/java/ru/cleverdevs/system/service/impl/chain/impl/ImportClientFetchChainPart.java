package ru.cleverdevs.system.service.impl.chain.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.cleverdevs.system.dto.deprecated.ClientDto;
import ru.cleverdevs.system.service.DeprecatedSystemAPI;
import ru.cleverdevs.system.service.impl.chain.NoteImportChainPart;
import ru.cleverdevs.system.service.impl.dto.NoteImportProcessDto;

/**
 * Часть цепочки импорта, отвечающая за получение клиентов из устаревшей системы
 *
 * @author Pavel Zhykhar
 */
@Order(1)
@Component
@RequiredArgsConstructor
public class ImportClientFetchChainPart implements NoteImportChainPart {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportClientFetchChainPart.class);

    private final DeprecatedSystemAPI system;

    /**
     * Обрабатывает процесс импорта клиентов
     *
     * <p> Извлекает список клиентов из устаревшей системы и сохраняет его в {@link NoteImportProcessDto}</p>
     *
     * @param noteImportProcessDto объект для хранения данных импорта
     * @return обновленный объект {@link NoteImportProcessDto}
     */
    @Override
    public NoteImportProcessDto process(NoteImportProcessDto noteImportProcessDto) {
        LOGGER.info("ImportClientFetchChainPart process started");
        List<ClientDto> clients = system.getAllClients();

        noteImportProcessDto.setClients(clients);

        clients.forEach(client ->
            LOGGER.info(String.join(", ",
                "Processing client: GUID=" + client.getGuid(),
                "Agency=" + client.getAgency(),
                "First Name=" + client.getFirstName(),
                "Last Name=" + client.getLastName(),
                "Status=" + client.getStatus(),
                "DOB=" + client.getDob(),
                "Created Date Time=" + client.getCreatedDateTime(),
                "Logged User=" + client.getLoggedUser()
            ))
        );

        LOGGER.info("ImportClientFetchChainPart process finished");
        return noteImportProcessDto;
    }
}
