package ru.cleverdevs.system.service.impl;

import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import ru.cleverdevs.system.dto.deprecated.ClientDto;
import ru.cleverdevs.system.dto.deprecated.NoteDto;
import ru.cleverdevs.system.dto.deprecated.NoteRequest;
import ru.cleverdevs.system.service.DeprecatedSystemAPI;

/**
 * Сервис для взаимодействия со старой системой через REST API
 * <p>
 * Данный класс предоставляет методы для получения данных о клиентах и заметках из старой системы
 * Все вызовы выполняются через {@link RestTemplate}, который использует HTTP-запросы к конечным точкам API
 * </p>
 *
 * @author Pavel Zhykhar
 */
@Service
public class DeprecatedSystemService implements DeprecatedSystemAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeprecatedSystemService.class);

    private final RestTemplate restTemplate;

    private final String BASE_URL;


    public DeprecatedSystemService(@Value("${URL.DEPRECATED_SERVICE}") String baseUrl, RestTemplate restTemplate) {
        this.BASE_URL = baseUrl;
        this.restTemplate = restTemplate;
    }

    /**
     * Получает список всех клиентов из старой системы
     *
     * @return Список объектов {@link ClientDto}, представляющих клиентов
     * Если запрос не возвращает клиентов, возвращается пустой список
     */
    @Override
    public List<ClientDto> getAllClients() {
        ResponseEntity<List<ClientDto>> response = restTemplate.exchange(
            "http://localhost:8080/clients",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<ClientDto>>() {}
        );
        return response.getBody() != null ? response.getBody() : Collections.emptyList();
    }

    /**
     * Получает список заметок для конкретного клиента из старой системы
     *
     * @param request объект {@link NoteRequest}, содержащий данные для запроса заметок
     * @return Список объектов {@link NoteDto}, представляющих заметки клиента
     * Если запрос не возвращает заметки или возникает ошибка, возвращается пустой список
     */
    @Override
    public List<NoteDto> getClientNotes(NoteRequest request) {
        LOGGER.info("Sending request: {}", request);

        try {
            ResponseEntity<List<NoteDto>> response = restTemplate.exchange(
                BASE_URL + "/notes",
                HttpMethod.POST,
                new HttpEntity<>(request),
                new ParameterizedTypeReference<List<NoteDto>>() {}
            );

            List<NoteDto> body = response.getBody();

            if (body == null || body.isEmpty()) {
                LOGGER.warn("Received empty response from the server.");
                return Collections.emptyList();
            }
            return body;

        } catch (HttpServerErrorException e) {
            LOGGER.error("Server error occurred: {}", e.getResponseBodyAsString());
        } catch (HttpClientErrorException e) {
            LOGGER.error("Client error occurred: {}", e.getResponseBodyAsString());
        } catch (Exception e) {
            LOGGER.error("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }
}
