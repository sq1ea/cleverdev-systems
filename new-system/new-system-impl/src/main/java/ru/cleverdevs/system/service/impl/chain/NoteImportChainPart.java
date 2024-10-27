package ru.cleverdevs.system.service.impl.chain;

import ru.cleverdevs.system.service.impl.chain.impl.ImportClientFetchChainPart;
import ru.cleverdevs.system.service.impl.chain.impl.ImportNoteFetchChainPart;
import ru.cleverdevs.system.service.impl.chain.impl.ImportNoteSaveChainPart;
import ru.cleverdevs.system.service.impl.chain.impl.ImportPatientMappingChainPart;
import ru.cleverdevs.system.service.impl.chain.impl.ImportUserMappingChainPart;
import ru.cleverdevs.system.service.impl.dto.NoteImportProcessDto;

/**
 * Интерфейс цепочки обработки данных для импорта заметок
 * <p>
 * Этот интерфейс определяет метод для обработки данных на каждом шаге импорта заметок,
 * позволяя каждой реализации обрабатывать данные и возвращать обновленный объект импорта
 * </p>
 *
 * @author Pavel Zhykhar
 * @see ImportClientFetchChainPart - 1 шаг: получение клиентов из устаревшей системы
 * @see ImportPatientMappingChainPart - 2 шаг: сопоставление клиентов и пациентов
 * @see ImportUserMappingChainPart - 3 шаг: сопоставление пользователей
 * @see ImportNoteFetchChainPart - 4 шаг: получение заметок для клиентов
 * @see ImportNoteSaveChainPart - 5 шаг: сохранение или обновление заметок в новой системе
 */
public interface NoteImportChainPart {

    /**
     * Обрабатывает процесс импорта данных
     *
     * @param noteImportProcessDto объект, содержащий данные импорта
     * @return обновленный объект {@link NoteImportProcessDto}
     */
    NoteImportProcessDto process(NoteImportProcessDto noteImportProcessDto);
}
