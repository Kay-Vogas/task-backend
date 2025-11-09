package com.software.Tarefas_Backend.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false,length = 150)
    String nome;

    @Lob
    @Column(nullable = false)
    String descricao;

    @Column(nullable = false)
    Boolean status;

    public Task(){}
}
