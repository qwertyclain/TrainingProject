package ru.stepanov.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stepanov.project.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}