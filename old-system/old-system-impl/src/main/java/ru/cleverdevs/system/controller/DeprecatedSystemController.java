package ru.cleverdevs.system.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.cleverdevs.system.dto.ClientDto;
import ru.cleverdevs.system.dto.NoteDto;
import ru.cleverdevs.system.payload.NoteRequest;
import ru.cleverdevs.system.service.DeprecatedSystemService;

/**
 * Контроллер для обработки запросов к устаревшей системе
 *
 * @author Pavel Zhykhar
 */
@RestController
@RequiredArgsConstructor
public class DeprecatedSystemController {

    private final DeprecatedSystemService service;

    /**
     * Обрабатывает GET-запрос для получения списка всех клиентов
     *
     * @return ResponseEntity с списком DTO клиентов
     */
    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        List<ClientDto> clients = service.getAllClients();
        return ResponseEntity.ok(clients);
    }

    /**
     * Обрабатывает POST-запрос для получения заметок клиента по запросу
     *
     * @param request объект, содержащий данные для получения заметок
     * @return ResponseEntity с списком DTO заметок клиента
     */
    @PostMapping("/notes")
    public ResponseEntity<List<NoteDto>> getClientNotes(@RequestBody NoteRequest request) {
        List<NoteDto> response = service.getClientNotes(
            request.getClientGuid(),
            request.getAgency(),
            request.getDateFrom(),
            request.getDateTo()
        );
        return ResponseEntity.ok(response);
    }
}
