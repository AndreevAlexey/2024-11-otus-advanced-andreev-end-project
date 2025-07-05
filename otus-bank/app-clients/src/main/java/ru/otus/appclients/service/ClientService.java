package ru.otus.appclients.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.appclients.repository.ClientRepository;
import ru.otus.appclients.model.Client;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    @Transactional(readOnly = true)
    public List<Client> getAll() {
        return clientRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Client findByInn(String inn) {
        return clientRepository.findClientByInn(inn).orElse(null);
    }


    @Transactional
    public Client save(Client item) {
        return clientRepository.save(item);
    }
}
