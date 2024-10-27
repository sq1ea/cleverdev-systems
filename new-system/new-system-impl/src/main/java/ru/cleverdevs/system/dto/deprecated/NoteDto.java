package ru.cleverdevs.system.dto.deprecated;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Класс представляет заметку в системе
 *
 * @author Pavel Zhykhar
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {
     /**
      * Уникальный идентификатор заметки
      */
     private UUID noteId;

     /**
      * Агентство, к которому относится клиент
      */
     private String agency;

     /**
      * Уникальный идентификатор клиента
      */
     private UUID clientGuid;

     /**
      * Текст заметки
      */
     private String comments;

     /**
      * Дата и время создания заметки
      */
     private LocalDateTime createdDateTime;

     /**
      * Дата и время последнего изменения заметки
      */
     private LocalDateTime modifiedDateTime;

     /**
      * Логин пользователя, создавшего заметку
      */
     private String loggedUser;
}
