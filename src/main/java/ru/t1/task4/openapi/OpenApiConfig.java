package ru.t1.task4.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Student Api",
                description = "Cервис предоставляет информацию о студентах курса. ", version = "1.0.0",
                contact = @Contact(
                        name = "Anatoly",
                        email = "gretskih@mail.ru"
                )
        )
)
public class OpenApiConfig {
}
