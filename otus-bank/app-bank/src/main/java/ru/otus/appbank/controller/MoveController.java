package ru.otus.appbank.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.appbank.service.MoveService;
import ru.otus.common.dto.MoveDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;



@RestController
@RequiredArgsConstructor
public class MoveController {

    private final MoveService moveService;


    @GetMapping("/move")
    public List<MoveDto> getAll(@RequestParam("begin") Optional<LocalDate> begin,
                                @RequestParam("end") Optional<LocalDate> end) {
        return moveService.getAll(begin, end);
    }


    @GetMapping("/move/{account}")
    public List<MoveDto> findAllByAccount(@PathVariable("account") String account) {
        return moveService.findAllByAccount(account);
    }


    @PostMapping("/move")
    public MoveDto add(@RequestBody MoveDto item) {
        return moveService.add(item);
    }

}
