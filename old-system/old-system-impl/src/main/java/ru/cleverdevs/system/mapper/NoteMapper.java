package ru.cleverdevs.system.mapper;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.cleverdevs.system.dto.NoteDto;
import ru.cleverdevs.system.models.Client;
import ru.cleverdevs.system.models.Note;

/**
 * Маппер для преобразования {@linkplain Note} и {@linkplain NoteDto}
 *
 * @author Pavel Zhykhar
 */
@Mapper(componentModel = "spring")
public interface NoteMapper {

    /**
     * Преобразует {@link Note} в {@link NoteDto}
     *
     * @param note объект, который нужно преобразовать
     * @return {@link NoteDto}
     */
    @Mapping(source = "clientGuid.guid", target = "clientGuid")
    NoteDto mapToDto(Note note);

    /**
     * Преобразует объект {@link NoteDto} в сущность {@link Note}
     *
     * @param noteDto объект, который нужно преобразовать
     * @return объект {@link Note}
     */
    Note mapToEntity(NoteDto noteDto);

    default Client map(UUID clientGuid) {
        if (clientGuid == null) {
            return null;
        }
        Client client = new Client();
        client.setGuid(clientGuid);
        return client;
    }

    default UUID map(Client client) {
        return client != null ? client.getGuid() : null;
    }
}
