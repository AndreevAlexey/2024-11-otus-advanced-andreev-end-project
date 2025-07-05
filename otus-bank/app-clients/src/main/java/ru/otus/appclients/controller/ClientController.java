package ru.otus.appclients.controller;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.common.dto.ClientDto;
import ru.otus.appclients.model.Client;
import ru.otus.appclients.service.ClientService;

import java.util.List;



@Tag(
        name = "Clients API",
        description = "Api for clients"
)
@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @GetMapping("/client")
    public List<ClientDto> getAll() {
        return
                clientService.getAll()
                        .stream()
                        .map(Client::toDto)
                        .toList();
    }


    @GetMapping("/client/{inn}")
    public ClientDto findByInn(
            @Parameter(description = "inn", required = true) @PathVariable("inn") String inn) {
        Client client = clientService.findByInn(inn);
        return
                (client != null)
                        ? client.toDto()
                        : null;
    }


    @PutMapping("/client")
    public ClientDto update(@RequestBody ClientDto item) {
        Client entity = Client.toEntity(item);
        return clientService.save(entity).toDto();
    }


    @PostMapping("/client")
    public ClientDto add(@RequestBody ClientDto item) {
        Client entity = Client.toEntity(item);
        return clientService.save(entity).toDto();
    }
}
