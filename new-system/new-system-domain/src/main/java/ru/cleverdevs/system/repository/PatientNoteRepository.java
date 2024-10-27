package ru.cleverdevs.system.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cleverdevs.system.model.PatientNote;

@Repository
public interface PatientNoteRepository extends JpaRepository<PatientNote, UUID> {

}
