package ru.stepanov.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stepanov.project.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}