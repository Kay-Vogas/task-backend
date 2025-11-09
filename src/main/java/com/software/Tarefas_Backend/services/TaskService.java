package com.software.Tarefas_Backend.services;

import com.software.Tarefas_Backend.entities.Task;
import com.software.Tarefas_Backend.repositories.TaskRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {

    @Autowired
    private TaskRespository taskRespository;


    @Transactional
    public Task createTask(Task task){
        if(task == null){
            return null;
        }else {
             return taskRespository.save(task);
        }
    }


}
