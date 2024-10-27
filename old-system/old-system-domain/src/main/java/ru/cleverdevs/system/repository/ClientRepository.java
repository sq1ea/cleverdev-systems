package ru.cleverdevs.system.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cleverdevs.system.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    Client findByGuid(UUID guid);
}
