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
 * Класс представляет клиента в системе
 *
 * @author Pavel Zhykhar
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
     @NotNull(message = "Поле guid не может быть пустым")
     @Schema(description = "Уникальный идентификатор клиента")
     private UUID guid;

     @Schema(description = "Агентство, к которому относится клиент")
     private String agency;

     @Schema(description = "Имя клиента")
     @NotNull(message = "Поле firstName не может быть пустым")
     private String firstName;

     @Schema(description = "Фамилия клиента")
     private String lastName;

     @Schema(description = "Статус клиента")
     private String status;

     private String loggedUser;

     @Schema(description = "Дата рождения клиента")
     private LocalDateTime dob;

     @NotNull(message = "Поле createdDateTime не может быть пустым")
     @Schema(description = "Дата и время создания записи о клиенте")
     private LocalDateTime createdDateTime;
}
