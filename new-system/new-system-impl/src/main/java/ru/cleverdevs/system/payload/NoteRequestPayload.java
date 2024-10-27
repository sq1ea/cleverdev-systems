package ru.cleverdevs.system.payload;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoteRequestPayload {
    /**
     * Уникальный идентификатор клиента (GUID)
     */
    private String clientGuid;

    /**
     * Код агентства, к которому приписан клиент
     */
    private String agency;

    /**
     * Дата начала выборки заметок
     */
    private LocalDate dateFrom;

    /**
     * Дата окончания выборки заметок
     */
    private LocalDate dateTo;
}
