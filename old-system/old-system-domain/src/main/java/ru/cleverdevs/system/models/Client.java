package ru.cleverdevs.system.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
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
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID guid;

    /**
     * Агентство, к которому относится клиент
     */
    @Column(name = "agency", nullable = false)
    private String agency;

    /**
     * Имя клиента
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Фамилия клиента
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Статус клиента
     */
    @Column(name = "status")
    private String status;

    /**
     * Дата рождения клиента
     */
    @Column(name = "dob")
    private LocalDateTime dob;

    /**
     * Дата и время создания записи о клиенте
     */
    @Column(name = "created_date_time", nullable = false)
    private LocalDateTime createdDateTime;
}
