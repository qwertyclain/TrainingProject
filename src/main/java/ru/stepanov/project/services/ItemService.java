package ru.stepanov.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepanov.project.models.Item;
import ru.stepanov.project.repositories.ItemRepository;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository repository;

    @Autowired
    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> getItemsList() {
        return repository.findAll();
    }

    public Item getItem(int id) {
        return repository.findById(id).orElse(null);
    }

    public void editItem(Item updatedItem, int id) {
        Item mustBeUpdated = getItem(id);

        mustBeUpdated.setName(updatedItem.getName());
        mustBeUpdated.setWeight(updatedItem.getWeight());
        mustBeUpdated.setRating(updatedItem.getRating());

        repository.save(mustBeUpdated);
    }

    public void addNewItem(Item item) {
        repository.save(item);
    }

    public void deleteItem(int id) {
        repository.deleteById(id);
    }
}