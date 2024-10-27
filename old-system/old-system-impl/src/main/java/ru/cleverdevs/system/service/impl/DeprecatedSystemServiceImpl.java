package ru.cleverdevs.system.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cleverdevs.system.dto.ClientDto;
import ru.cleverdevs.system.dto.NoteDto;
import ru.cleverdevs.system.mapper.ClientMapper;
import ru.cleverdevs.system.mapper.NoteMapper;
import ru.cleverdevs.system.models.Client;
import ru.cleverdevs.system.models.Note;
import ru.cleverdevs.system.repository.ClientRepository;
import ru.cleverdevs.system.repository.NoteRepository;
import ru.cleverdevs.system.service.DeprecatedSystemService;

/**
 * Реализация сервиса для работы с данными из устаревшей системы
 *
 * @author Pavel Zhykhar
 */
@Service
@RequiredArgsConstructor
public class DeprecatedSystemServiceImpl implements DeprecatedSystemService {

    private final ClientRepository clientRepository;
    private final ClientMapper mapper;
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    /**
     * Получает список всех клиентов
     *
     * @return список DTO клиентов
     */
    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();

        List<Note> notes = noteRepository.findAll();

        Map<UUID, String> clientToLoggedUserMap = notes.stream()
            .collect(Collectors.toMap(
                note -> note.getClientGuid().getGuid(),
                Note::getLoggedUser
            ));

        return clients.stream()
            .map(client -> {
                ClientDto clientDto = mapper.mapToDto(client);
                String loggedUser = clientToLoggedUserMap.get(client.getGuid());
                clientDto.setLoggedUser(loggedUser);
                return clientDto;
            })
            .toList();    }

    /**
     * Получает заметки для конкретного клиента за указанный период
     *
     * @param clientGuid уникальный идентификатор клиента
     * @param agency агентство, к которому относится клиент
     * @param dateFrom дата начала периода
     * @param dateTo дата окончания периода
     * @return список DTO заметок клиента
     */
    @Override
    public List<NoteDto> getClientNotes(UUID clientGuid, String agency, LocalDate dateFrom, LocalDate dateTo) {
        List<Note> notes = noteRepository.findNotesByClientGuid(clientGuid, agency, dateFrom.atStartOfDay(), dateTo.plusDays(1).atStartOfDay());
        return notes.stream().map(noteMapper::mapToDto).toList();
    }
}
