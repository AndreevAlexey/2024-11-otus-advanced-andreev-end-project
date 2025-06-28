package ru.otus.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Schema(description = "Currency Dto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {

    @Schema(description = "Currency id")
    private long id;

    @Schema(description = "Currency code")
    private String code;

    @Schema(description = "Currency name")
    private String name;

    @Schema(description = "Currency curs")
    private double curs;

}
