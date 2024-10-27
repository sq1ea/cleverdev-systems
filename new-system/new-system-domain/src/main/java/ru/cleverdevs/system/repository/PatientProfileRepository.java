package ru.cleverdevs.system.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.cleverdevs.system.model.PatientProfile;

@Repository
public interface PatientProfileRepository extends JpaRepository<PatientProfile, UUID> {

    @Query("SELECT p FROM PatientProfile p WHERE p.oldClientGuid = :oldClientGuid")
    PatientProfile findByOldClientGuid(@Param("oldClientGuid") String oldClientGuid);
}
