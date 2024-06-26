package ru.t1.task4.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Сущность ошибка")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ErrorMessage {
    private String message;
    private String details;
}
