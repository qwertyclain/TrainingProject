package ru.stepanov.project.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double weight;
    private double rating;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Client owner;
}