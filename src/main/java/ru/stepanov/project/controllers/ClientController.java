package ru.stepanov.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stepanov.project.models.Client;
import ru.stepanov.project.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/get-all")
    public List<Client> geClientList() {
        return service.getPeopleList();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable("id") int id) {
        return service.getClient(id);
    }

    @PostMapping("/new")
    public ResponseEntity<Client> addNewClient(@RequestBody Client client) {
        service.addNewClient(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Client> editClient(@RequestBody Client client,
                                             @PathVariable("id") int id) {
        service.editClient(client, id);
        return new ResponseEntity<>(client, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/drop/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") int id) {
        service.deleteClient(id);
        return new ResponseEntity<>("Клиент был успешно удалён!", HttpStatus.ACCEPTED);
    }
}