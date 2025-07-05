package ru.otus.appbank.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.appbank.service.ClientService;
import ru.otus.common.dto.ClientDto;

import java.util.List;



@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @GetMapping("/client")
    public List<ClientDto> getClients() {
        return clientService.getClients();
    }


    @GetMapping("/client/{inn}")
    public ClientDto findByInn(@PathVariable("inn") String inn) {
        return clientService.findByInn(inn);
    }


    @PutMapping("/client")
    public ClientDto update(@RequestBody ClientDto item) {
        return clientService.update(item);
    }


    @PostMapping("/client")
    public ClientDto add(@RequestBody ClientDto item) {
        return clientService.add(item);
    }

}
