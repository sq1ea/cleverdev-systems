package ru.cleverdevs.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.cleverdevs.system.dto.PatientNoteDto;
import ru.cleverdevs.system.model.PatientNote;

/**
 * Маппер для преобразования {@linkplain PatientNote} и {@linkplain PatientNoteDto}
 *
 * @author Pavel Zhykhar
 */
@Mapper(componentModel = "spring")
public interface PatientNoteMapper {

    /**
     * Преобразует {@link PatientNote} в {@link PatientNoteDto}
     *
     * @param patientNote объект, который нужно преобразовать
     * @return {@link PatientNoteDto}
     */
    @Mapping(source = "createdBy.id", target = "createdByUserId")
    @Mapping(source = "lastModifiedBy.id", target = "lastModifiedByUserId")
    @Mapping(source = "patient.id", target = "patientId")
    PatientNoteDto toDto(PatientNote patientNote);

    /**
     * Преобразует {@link PatientNoteDto} в {@link PatientNote}
     *
     * @param patientNoteDto объект, который нужно преобразовать
     * @return {@link PatientNote}
     */
    @Mapping(source = "createdByUserId", target = "createdBy.id")
    @Mapping(source = "lastModifiedByUserId", target = "lastModifiedBy.id")
    @Mapping(source = "patientId", target = "patient.id")
    PatientNote toEntity(PatientNoteDto patientNoteDto);
}
