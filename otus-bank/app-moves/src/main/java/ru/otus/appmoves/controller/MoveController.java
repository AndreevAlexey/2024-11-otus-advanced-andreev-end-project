package ru.otus.appmoves.controller;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.appmoves.model.Move;
import ru.otus.appmoves.service.MoveService;
import ru.otus.common.dto.MoveDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Tag(
        name = "Move API",
        description = "Api for moves"
)
@RestController
@RequiredArgsConstructor
public class MoveController {

    private final MoveService moveService;


    @GetMapping("/move")
    public List<MoveDto> getAll(
            @Parameter(description = "begin date", example = "2025-05-01")
            @RequestParam("begin") Optional<LocalDate> begin,
            @Parameter(description = "end date", example = "2025-05-01")
            @RequestParam("end") Optional<LocalDate> end) {
        return
                (begin.isPresent() && end.isPresent())
                ? moveService.findAllByDocDateBetween(begin.get(), end.get())
                        .stream()
                        .map(Move::toDto)
                        .toList()
                : moveService.getAll()
                        .stream()
                        .map(Move::toDto)
                        .toList();
    }


    @GetMapping("/move/{account}")
    public List<MoveDto> findAllByAccount(
            @Parameter(description = "account num", required = true) @PathVariable("account") String account) {
        return
                moveService.findAllByAccount(account)
                        .stream()
                        .map(Move::toDto)
                        .toList();
    }


    @PostMapping("/move")
    public MoveDto add(@RequestBody MoveDto dto) {
        Move entity = Move.toEntity(dto);
        return moveService.save(entity).toDto();
    }

}
