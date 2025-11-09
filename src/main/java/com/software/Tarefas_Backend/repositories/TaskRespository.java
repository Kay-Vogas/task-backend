package com.software.Tarefas_Backend.repositories;

import com.software.Tarefas_Backend.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRespository extends JpaRepository<Task,Long> {
}

