package ru.stepanov.project.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepanov.project.models.Client;
import ru.stepanov.project.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> getPeopleList() {
        return repository.findAll();
    }

    public Client getClient(int id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void editClient(Client updatedClient, int id) {
        Client mustBeUpdated = getClient(id);

        mustBeUpdated.setName(updatedClient.getName());
        mustBeUpdated.setSecondName(updatedClient.getSecondName());
        mustBeUpdated.setAge(updatedClient.getAge());

        repository.save(mustBeUpdated);
    }

    public void addNewClient(Client client) {
        repository.save(client);
    }

    public void deleteClient(int id) {
        repository.deleteById(id);
    }
}