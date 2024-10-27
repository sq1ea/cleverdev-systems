package ru.cleverdevs.system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "company_user", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
public class CompanyUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Логин пользователя, должен быть уникальным.
     */
    @Column(nullable = false, length = 255)
    private String login;

    public CompanyUser (String login) {
        this.login = login;
    }
}
