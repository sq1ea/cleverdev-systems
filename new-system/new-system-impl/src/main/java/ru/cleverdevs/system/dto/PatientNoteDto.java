package ru.cleverdevs.system.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import lombok.ToString;

/**
 * Класс представляет пациента
 *
 * @author Pavel Zhykhar
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PatientNoteDto {
    /**
     * Уникальный идентификатор заметки
     */
    private UUID id;

    /**
     * Дата и время создания заметки
     */
    private LocalDateTime createdDateTime;

    /**
     * Дата и время последнего изменения заметки
     */
    private LocalDateTime lastModifiedDateTime;

    /**
     * Идентификатор пользователя, создавшего заметку
     */
    private UUID createdByUserId;

    /**
     * Идентификатор пользователя, последнего изменившего заметку
     */
    private UUID lastModifiedByUserId;

    /**
     * Текст заметки
     */
    private String note;

    /**
     * Идентификатор пациента, к которому относится заметка
     */
    private UUID patientId;
}
