package ru.cleverdevs.system.mapper;

import org.mapstruct.Mapper;
import ru.cleverdevs.system.dto.ClientDto;
import ru.cleverdevs.system.models.Client;

/**
 * Маппер для преобразования {@linkplain Client} и {@linkplain ClientDto}
 *
 * @author Pavel Zhykhar
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {

    /**
     * Преобразует {@link Client} в {@link ClientDto}
     *
     * @param client объект, который нужно преобразовать
     * @return {@link ClientDto}
     */
    ClientDto mapToDto(Client client);

    /**
     * Преобразует объект {@link ClientDto} в сущность {@link Client}
     *
     * @param clientDto объект, который нужно преобразовать
     * @return объект {@link Client}
     */
    Client mapToEntity(ClientDto clientDto);
}
