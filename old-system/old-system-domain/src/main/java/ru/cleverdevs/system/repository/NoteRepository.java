package ru.cleverdevs.system.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.cleverdevs.system.models.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {

    @Query("SELECT n FROM Note n WHERE n.clientGuid.guid = :clientGuid AND n.agency = :agency AND n.createdDateTime BETWEEN :dateFrom AND :dateTo")
    List<Note> findNotesByClientGuid(
        @Param("clientGuid") UUID clientGuid,
        @Param("agency") String agency,
        @Param("dateFrom") LocalDateTime dateFrom,
        @Param("dateTo") LocalDateTime dateTo);
}
