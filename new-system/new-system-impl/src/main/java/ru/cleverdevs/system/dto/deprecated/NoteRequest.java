package ru.cleverdevs.system.dto.deprecated;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
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
