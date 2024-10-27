package ru.cleverdevs.system.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cleverdevs.system.service.impl.chain.NoteImportChainPart;
import ru.cleverdevs.system.service.impl.dto.NoteImportProcessDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Сервис для планирования и выполнения импорта заметок из старой системы
 * <p>
 * Этот класс управляет цепочкой обработки данных для импорта заметок
 * выполняя последовательные шаги, определенные в {@link NoteImportChainPart}
 * </p>
 *
 * @author Pavel Zhykhar
 */
@Service
@RequiredArgsConstructor
public class ScheduledService {

    private final Logger logger = LoggerFactory.getLogger(ScheduledService.class);
    private final List<NoteImportChainPart> chainParts;

    /**
     * Запускает процесс импорта заметок по расписанию
     * <p>
     * Метод выполняет последовательную обработку цепочки {@link NoteImportChainPart} начиная с
     * инициализации данных и заканчивая сохранением заметок в новой системе
     * </p>
     * <p>
     * Метод запускается по расписанию с помощью аннотации {@link Scheduled}
     */
    @Scheduled(cron = "*/10 * * * * ?")
    @Transactional
    public void proccesChainParts(){
        NoteImportProcessDto dto = new NoteImportProcessDto();
        logger.info("Scheduled task started");
        for (NoteImportChainPart part : chainParts) {
            dto = part.process(dto);
        }
    }
}
