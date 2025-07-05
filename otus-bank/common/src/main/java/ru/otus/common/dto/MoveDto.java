package ru.otus.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Schema(description = "Move Dto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoveDto {

    @Schema(description = "Move id")
    private long id;

    @Schema(description = "Account Debit")
    private String accDt;

    @Schema(description = "Account Credit")
    private String accKt;

    @Schema(description = "Move date")
    private LocalDate docDate;

    @Schema(description = "Sum Debit")
    private double sumDt;

    @Schema(description = "Sum Credit")
    private double sumKt;

    @Schema(description = "Description")
    private String description;
}
