package ru.stepanov.project.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Person")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "second_name")
    private String secondName;
    private int age;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Item> itemList;
}