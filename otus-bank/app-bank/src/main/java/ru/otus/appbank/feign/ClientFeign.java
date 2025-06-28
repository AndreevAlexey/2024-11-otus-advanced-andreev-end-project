package ru.otus.appbank.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.otus.common.dto.ClientDto;


import java.util.List;

@FeignClient(name = "ClientFeign", url = "${feign.gateway.url}")
public interface ClientFeign {

    @GetMapping("/client")
    List<ClientDto> getClients();


    @GetMapping("/client/{inn}")
    ClientDto findByInn(@PathVariable("inn") String inn);


    @PutMapping("/client")
    ClientDto update(@RequestBody ClientDto item);


    @PostMapping("/client")
    ClientDto add(@RequestBody ClientDto item);

}
