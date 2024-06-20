package com.desafiobackendjr.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID;
    private String name;
    private String description;
    private boolean realized;
    private int priority;

}
