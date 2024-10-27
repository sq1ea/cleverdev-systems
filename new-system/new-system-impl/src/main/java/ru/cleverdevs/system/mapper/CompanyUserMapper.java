package ru.cleverdevs.system.mapper;

import org.mapstruct.Mapper;
import ru.cleverdevs.system.dto.CompanyUserDto;
import ru.cleverdevs.system.model.CompanyUser;

/**
 * Маппер для преобразования {@linkplain CompanyUser} и {@linkplain CompanyUserDto}
 *
 * @author Pavel Zhykhar
 */
@Mapper(componentModel = "spring")
public interface CompanyUserMapper {

    /**
     * Преобразует {@link CompanyUser} в {@link CompanyUserDto}
     *
     * @param companyUser объект, который нужно преобразовать
     * @return {@link CompanyUserDto}
     */
    CompanyUserDto mapToDto(CompanyUser companyUser);

    /**
     * Преобразует объект {@link CompanyUserDto} в сущность {@link CompanyUser}
     *
     * @param companyUserDto объект, который нужно преобразовать
     * @return объект {@link CompanyUser}
     */
    CompanyUser mapToEntity(CompanyUserDto companyUserDto);
}
