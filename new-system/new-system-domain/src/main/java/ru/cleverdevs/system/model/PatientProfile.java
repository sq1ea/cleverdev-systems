package ru.cleverdevs.system.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Представляет частоту платежей
 *
 * @author Pavel Zhykhar
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient_profile")
public class PatientProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Имя пациента
     */
    @Column(length = 255)
    private String firstName;

    /**
     * Фамилия пациента
     */
    @Column(length = 255)
    private String lastName;

    /**
     * Уникальный идентификатор старого клиента
     */
    @Column(length = 255)
    private String oldClientGuid;

    /**
     * Статус пациента
     */
    @Column(nullable = false)
    private Short statusId;
}
