package ru.cleverdevs.system.dto.deprecated;

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
     /**
      * Уникальный идентификатор клиента. Не может быть пустым
      */
     private UUID guid;

     /**
      * Агентство, к которому относится клиент
      */
     private String agency;

     /**
      * Имя клиента. Не может быть пустым
      */
     private String firstName;

     /**
      * Фамилия клиента
      */
     private String lastName;

     /**
      * Статус клиента
      */
     private String status;

     /**
      * Дата рождения клиента
      */
     private LocalDateTime dob;

     /**
      * Дата и время создания записи о клиенте. Не может быть пустым
      */
     private LocalDateTime createdDateTime;

     /**
      * Имя пользователя
      */
     private String loggedUser;
}
