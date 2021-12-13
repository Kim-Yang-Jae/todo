package com.kyj.todo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Todo API",
                description = "Todo 관련 API 명세",
                termsOfService = "http://swagger.io/terms/",
                contact = @Contact(
                        name = "kim yang jae",
                        url = "https://github.com/Kim-Yang-Jae",
                        email = "kyj-9488@hanmail.net"
                )
        ),
        tags = {
                @Tag(name = SwaggerTag.Todo.TAG, description = SwaggerTag.Todo.DESC)
        }
)

@Configuration
public class SwaggerConfig {
}
