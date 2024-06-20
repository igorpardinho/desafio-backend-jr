package com.desafiobackendjr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "todos")
@NoArgsConstructor
@Getter
@Setter
public class Todo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public Todo(String name, String description, boolean realized, int priority) {
        this.name = name;
        this.description = description;
        this.realized = realized;
        this.priority = priority;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID;

    private String name;

    private String description;

    private boolean realized;

    private int priority;

}
