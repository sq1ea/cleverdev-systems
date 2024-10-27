package ru.cleverdevs.system.service.impl.chain.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.cleverdevs.system.dto.deprecated.ClientDto;
import ru.cleverdevs.system.dto.deprecated.NoteDto;
import ru.cleverdevs.system.dto.deprecated.NoteRequest;
import ru.cleverdevs.system.service.DeprecatedSystemAPI;
import ru.cleverdevs.system.service.impl.chain.NoteImportChainPart;
import ru.cleverdevs.system.service.impl.dto.NoteImportProcessDto;

/**
 * Часть цепочки импорта, отвечающая за получение заметок для клиентов
 *
 * @author Pavel Zhykhar
 */
@Order(4)
@Component
@RequiredArgsConstructor
public class ImportNoteFetchChainPart implements NoteImportChainPart {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportNoteFetchChainPart.class);

    private final DeprecatedSystemAPI system;

    /**
     * Обрабатывает процесс получения заметок для клиентов
     *
     * <p>Создает запросы для каждого клиента и извлекает их заметки из устаревшей системы </p>
     *
     * @param noteImportProcessDto объект для хранения данных импорта
     * @return обновленный объект {@link NoteImportProcessDto} с заметками по клиентам
     */
    @Override
    public NoteImportProcessDto process(NoteImportProcessDto noteImportProcessDto) {
        LOGGER.info("ImportClientFetchChainPart process started");
        Map<String, List<NoteDto>> notesByClient = new HashMap<>();
        for (ClientDto client : noteImportProcessDto.getClients()) {

            NoteRequest request = new NoteRequest();
            request.setClientGuid(client.getGuid());
            request.setAgency(client.getAgency());
            request.setDateTo(noteImportProcessDto.getDateTo());
            request.setDateFrom(noteImportProcessDto.getDateFrom());

            List<NoteDto> notes = system.getClientNotes(request);
            notesByClient.put(String.valueOf(client.getGuid()), notes);
        }
        noteImportProcessDto.setNotesByClient(notesByClient);
        LOGGER.info("ImportClientFetchChainPart process finished");
        return noteImportProcessDto;
    }
}
