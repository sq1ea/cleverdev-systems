package ru.cleverdevs.system.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс представляет заметку в системе
 *
 * @author Pavel Zhykhar
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "note")
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID noteId;

    /**
     * Агентство, связанное с клиентом из старой системы
     */
    @Column(name = "agency", nullable = false)
    private String agency;

    /**
     * Клиент, связанный с этой заметкой
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_guid", referencedColumnName = "guid", nullable = false)
    private Client clientGuid;

    /**
     * Содержимое заметки
     */
    @Column(name = "comments")
    private String comments;

    /**
     * Дата и время создания заметки
     */
    @Column(name = "created_date_time", nullable = false)
    private LocalDateTime createdDateTime;

    /**
     * Дата и время последнего изменения заметки
     */
    private LocalDateTime modifiedDateTime;

    /**
     * Логин пользователя, создавшего заметку
     */
    private String loggedUser;
}
