package ru.cleverdevs.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс представляет заметку в системе
 *
 * @author Pavel Zhykhar
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {
     @Schema(description = "Уникальный идентификатор заметки")
     private UUID noteId;

     @Schema(description = "Агентство, к которому относится клиент")
     private String agency;

     @Schema(description = "Уникальный идентификатор клиента")
     private UUID clientGuid;

     @Schema(description = "Текст заметки")
     private String comments;

     @NotNull(message = "Поле createdDateTime не может быть пустым")
     @Schema(description = "Дата и время создания заметки")
     private LocalDateTime createdDateTime;

     @Schema(description = "Дата и время последнего изменения заметки")
     private LocalDateTime modifiedDateTime;

     @Schema(description = "Логин пользователя, создавшего заметку")
     private String loggedUser;
}
