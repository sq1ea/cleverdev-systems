package ru.cleverdevs.system.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cleverdevs.system.model.CompanyUser;

@Repository
public interface CompanyUserRepository extends JpaRepository<CompanyUser, UUID> {

    Optional<CompanyUser> findByLogin(String login);
}
