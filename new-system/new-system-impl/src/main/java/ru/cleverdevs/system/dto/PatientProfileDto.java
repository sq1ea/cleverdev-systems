package ru.cleverdevs.system.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс для передачи данных профиля пациента
 *
 * @author Pavel Zhykhar
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientProfileDto {

    /**
     * Уникальный идентификатор пациента
     */
    private UUID id;

    /**
     * Имя пациента
     */
    private String firstName;

    /**
     * Фамилия пациента
     */
    private String lastName;

    /**
     * Уникальный идентификатор старого клиента
     */
    private String oldClientGuid;

    /**
     * Статус пациента
     */
    private Short statusId;
}
