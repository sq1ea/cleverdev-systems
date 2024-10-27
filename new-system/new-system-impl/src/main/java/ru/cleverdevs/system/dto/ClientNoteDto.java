package ru.cleverdevs.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Класс представляет пользователя создавшего заметку
 *
 * @author Pavel Zhykhar
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientNoteDto {
    /** Содержимое заметки */
    private String comments;

    /** Уникальный идентификатор заметки */
    private String guid;

    /** Дата и время последнего изменения заметки */
    private String modifiedDateTime;

    /** GUID клиента, связанного с заметкой */
    private String clientGuid;

    /** Дата и время создания заметки */
    private String datetime;

    /** Пользователь, создавший заметку */
    private String loggedUser;

    /** Дата и время создания заметки */
    private String createdDateTime;
}
