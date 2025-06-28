package ru.otus.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Schema(description = "Account Dto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    @Schema(description = "Account id")
    private long id;

    @Schema(description = "Account num")
    private String num;

    @Schema(description = "Account currency")
    private String currency;

    @Schema(description = "Account openDate")
    private LocalDate openDate;

    @Schema(description = "Account clientInn")
    private String clientInn;

    @Schema(description = "Account saldo")
    private double saldo;
}
