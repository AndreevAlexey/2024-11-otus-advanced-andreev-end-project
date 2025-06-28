package ru.otus.appmoves.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Moves Application",
                version = "1.2",
                license = @License(
                        name = "GPLv3",
                        url = "https://www.gnu.org/licenses/gpl-3.0.en.html"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8083", description = "Localhost")
        }
)
public class OpenApiConfig {
}
