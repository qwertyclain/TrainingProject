package ru.stepanov.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stepanov.project.models.Item;
import ru.stepanov.project.services.ItemService;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService service;

    @Autowired
    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/get-all")
    public List<Item> geItemsList() {
        return service.getItemsList();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable("id") int id) {
        return service.getItem(id);
    }

    @PostMapping("/new")
    public ResponseEntity<Item> addNewItem(@RequestBody Item item) {
        service.addNewItem(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Item> editItem(@RequestBody Item item,
                                             @PathVariable("id") int id) {
        service.editItem(item, id);
        return new ResponseEntity<>(item, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/drop/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") int id) {
        service.deleteItem(id);
        return new ResponseEntity<>("Товар был успешно удалён!", HttpStatus.ACCEPTED);
    }
}