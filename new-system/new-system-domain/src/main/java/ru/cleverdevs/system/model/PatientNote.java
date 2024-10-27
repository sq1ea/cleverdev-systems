package ru.cleverdevs.system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Представляет частоту платежей
 *
 *
 * @author Pavel Zhykhar
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient_note")
public class PatientNote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Дата и время создания заметки
     */
    @Column(nullable = false)
    private LocalDateTime createdDateTime;

    /**
     * Дата и время последнего изменения заметки
     */
    @Column(nullable = false)
    private LocalDateTime lastModifiedDateTime;

    /**
     * Пользователь, создавший заметку
     */
    @ManyToOne
    @JoinColumn(name = "created_by_user_id", referencedColumnName = "id")
    private CompanyUser createdBy;

    /**
     * Пользователь, внесший последнее изменение в заметку
     */
    @ManyToOne
    @JoinColumn(name = "last_modified_by_user_id", referencedColumnName = "id")
    private CompanyUser lastModifiedBy;

    /**
     * Текст заметки
     */
    @Column(length = 4000)
    private String note;

    /**
     * Пациент, к которому относится заметка
     */
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientProfile patient;
}
