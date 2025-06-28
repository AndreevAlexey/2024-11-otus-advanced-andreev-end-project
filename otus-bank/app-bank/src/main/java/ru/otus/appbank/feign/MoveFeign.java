package ru.otus.appbank.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.otus.common.dto.MoveDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@FeignClient(name = "MoveFeign", url = "${feign.gateway.url}")
public interface MoveFeign {

    @GetMapping("/move")
    List<MoveDto> getAll(@RequestParam("begin") Optional<LocalDate> begin,
                         @RequestParam("end") Optional<LocalDate> end);


    @GetMapping("/move/{account}")
    List<MoveDto> findAllByAccount(@PathVariable("account") String account);


    @PostMapping("/move")
    MoveDto add(@RequestBody MoveDto item);
}
