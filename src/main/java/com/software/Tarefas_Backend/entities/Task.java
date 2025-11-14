package com.software.Tarefas_Backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Priority prioridade;

    public Task(Task entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
