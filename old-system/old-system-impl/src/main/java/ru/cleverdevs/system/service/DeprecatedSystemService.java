package ru.cleverdevs.system.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import ru.cleverdevs.system.dto.ClientDto;
import ru.cleverdevs.system.dto.NoteDto;

/**
 * Интерфейс сервиса для работы с данными из устаревшей системы
 */
public interface DeprecatedSystemService {

    /**
     * Получает список всех клиентов
     *
     * @return список DTO клиентов
     */
    List<ClientDto> getAllClients();

    /**
     * Получает заметки для конкретного клиента за указанный период
     *
     * @param clientGuid уникальный идентификатор клиента
     * @param agency агентство, к которому относится клиент
     * @param dateFrom дата начала периода
     * @param dateTo дата окончания периода
     * @return список DTO заметок клиента
     */
    List<NoteDto> getClientNotes(UUID clientGuid, String agency, LocalDate dateFrom, LocalDate dateTo);
}
