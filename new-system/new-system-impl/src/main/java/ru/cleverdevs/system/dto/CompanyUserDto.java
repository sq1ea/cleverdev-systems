package ru.cleverdevs.system.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Класс представляет пользователя
 *
 * @author Pavel Zhykhar
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompanyUserDto {

    private UUID id;

    private String login;
}
