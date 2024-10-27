package ru.cleverdevs.system.mapper;

import org.mapstruct.Mapper;
import ru.cleverdevs.system.dto.PatientProfileDto;
import ru.cleverdevs.system.model.PatientProfile;

/**
 * Маппер для преобразования {@linkplain PatientProfile} и {@linkplain PatientProfileDto}
 *
 * @author Pavel Zhykhar
 */
@Mapper(componentModel = "spring")
public interface PatientProfileMapper {

    /**
     * Преобразует {@link PatientProfile} в {@link PatientProfileDto}
     *
     * @param patientProfile объект, который нужно преобразовать
     * @return {@link PatientProfileDto}
     */
    PatientProfileDto mapToDto(PatientProfile patientProfile);

    /**
     * Преобразует объект {@link PatientProfileDto} в сущность {@link PatientProfile}
     *
     * @param patientProfileDto объект, который нужно преобразовать
     * @return объект {@link PatientProfile}
     */
    PatientProfile mapToEntity(PatientProfileDto patientProfileDto);
}
