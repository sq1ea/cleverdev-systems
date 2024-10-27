package ru.cleverdevs.system.payload;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс представляет запрос на получение заметок для клиента
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoteRequest {

    /**
     * Агентство, к которому относится клиент
     */
    private String agency;

    /**
     * Уникальный идентификатор клиента
     */
    private UUID clientGuid;

    /**
     * Дата начала периода для выборки заметок
     */
    private LocalDate dateFrom;

    /**
     * Дата окончания периода для выборки заметок
     */
    private LocalDate dateTo;
}
