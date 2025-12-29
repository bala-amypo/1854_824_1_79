// package com.example.demo.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.servers.Server;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import java.util.List;

// @Configuration
// public class SwaggerConfig {

//     @Bean
//     public OpenAPI customOpenAPI() {
//         return new OpenAPI()
//                 .servers(List.of(
//                         new Server().url("https://9058.32procr.amypo.ai/")
//                 ));
//         }
// }

package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        // 🔐 Security scheme
        SecurityScheme securityScheme = new SecurityScheme()
                .name("Authorization")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        // 🔐 Apply security globally
        SecurityRequirement securityRequirement =
                new SecurityRequirement().addList("Authorization");

        return new OpenAPI()
                .info(new Info()
                        .title("Transport Route Optimization API")
                        .description("Swagger documentation with JWT authentication")
                        .version("1.0"))
                .addSecurityItem(securityRequirement)
                .schemaRequirement("Authorization", securityScheme);
    }
}
