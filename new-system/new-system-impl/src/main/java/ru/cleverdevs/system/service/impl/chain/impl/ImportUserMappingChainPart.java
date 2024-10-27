package ru.cleverdevs.system.service.impl.chain.impl;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.cleverdevs.system.dto.deprecated.ClientDto;
import ru.cleverdevs.system.model.CompanyUser;
import ru.cleverdevs.system.repository.CompanyUserRepository;
import ru.cleverdevs.system.service.impl.chain.NoteImportChainPart;
import ru.cleverdevs.system.service.impl.dto.NoteImportProcessDto;

/**
 * Часть цепочки импорта, отвечающая за сопоставление пользователей
 *
 * @author Pavel Zhykhar
 */
@Order(3)
@Component
@RequiredArgsConstructor
public class ImportUserMappingChainPart implements NoteImportChainPart {

    private final CompanyUserRepository repository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ImportUserMappingChainPart.class);

    /**
     * Обрабатывает процесс сопоставления пользователей для клиентов
     *
     * <p>Ищет пользователей по логинам клиентов и создает новых пользователей, если они не найдены </p>
     *
     * @param noteImportProcessDto объект для хранения данных импорта
     * @return обновленный объект {@link NoteImportProcessDto} с сопоставлением пользователей
     */
    @Override
    public NoteImportProcessDto process(NoteImportProcessDto noteImportProcessDto) {
        Map<String, CompanyUser> mappedUsers = new HashMap<>();

        LOGGER.info("Processing user mapping for {} clients", noteImportProcessDto.getClients().size());

        for (ClientDto client : noteImportProcessDto.getClients()) {
            String login = client.getLoggedUser();

            if (login == null) {
                LOGGER.warn("Client has null login, skipping this client");
                continue;
            }

            LOGGER.info("Processing client with login: {}", login);

            CompanyUser user = repository.findByLogin(login)
                .orElseGet(() -> {
                    LOGGER.info("User not found, creating new CompanyUser for login: {}", login);
                    return repository.save(new CompanyUser(login));
                });

            mappedUsers.put(login, user);

            LOGGER.info("Mapped user: {} to login: {}", user.getId(), login);
        }

        LOGGER.info("User mapping process finished with {} mappings", mappedUsers.size());

        noteImportProcessDto.setUserMapping(mappedUsers);
        return noteImportProcessDto;
    }
}
