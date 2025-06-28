package ru.otus.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Schema(description = "Client Dto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    @Schema(description = "id")
    private long id;

    @Schema(description = "Client fullName")
    private String fullName;

    @Schema(description = "Client birthDate")
    private LocalDate birthDate;

    @Schema(description = "Client mail")
    private String mail;

    @Schema(description = "Client inn")
    private String inn;

}
