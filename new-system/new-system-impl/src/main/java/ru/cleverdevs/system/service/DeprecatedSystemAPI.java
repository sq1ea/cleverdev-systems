package ru.cleverdevs.system.service;

import java.util.List;
import ru.cleverdevs.system.dto.deprecated.ClientDto;
import ru.cleverdevs.system.dto.deprecated.NoteDto;
import ru.cleverdevs.system.dto.deprecated.NoteRequest;

/**
 * Интерфейс для взаимодействия с устаревшей системой данных
 * <p>
 * Этот интерфейс определяет методы для получения информации о клиентах и заметках из старой системы
 * </p>
 */
public interface DeprecatedSystemAPI {

    /**
     * Получает всех клиентов из старой системы
     *
     * @return Список клиентов из старой системы
     */
    List<ClientDto> getAllClients();

    /**
     * Получает заметки для конкретного клиента из старой системы по clientGuid и agency
     *
     * @return Список заметок для указанного клиента в указанный временной промежуток
     */
    public List<NoteDto> getClientNotes(NoteRequest request);
}
