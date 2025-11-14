package com.software.Tarefas_Backend.services;

import com.software.Tarefas_Backend.entities.Task;
import com.software.Tarefas_Backend.repositories.TaskRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRespository taskRespository;

    @Transactional(readOnly = true)
    public List<Task> findAll(){
        return taskRespository.findAll();
    }

    @Transactional(readOnly = true)
    public Task findById(Long id){
        Task result = taskRespository.findById(id).get();
        return new Task(result);
    }

    @Transactional
    public Task createTask(Task task){
        if(task == null){
            return null;
        }else {
             return taskRespository.save(task);
        }
    }


    @Transactional
    public Task update(Long id , Task taskAtualizado){

        return taskRespository.findById(id).map(TaskExiste -> {
                    TaskExiste.setNome(taskAtualizado.getNome());
                    TaskExiste.setDescricao(taskAtualizado.getDescricao());
                    TaskExiste.setStatus(taskAtualizado.getStatus());
                    TaskExiste.setPrioridade(taskAtualizado.getPrioridade());

                    return taskRespository.save(TaskExiste);
                })
                .orElseThrow(() -> new RuntimeException("Task não encontrado com o id: " + id));
    }

    @Transactional
    public void delete(Long id){
        if (!taskRespository.existsById(id)) {
            throw new RuntimeException("Task não encontrado com o id: " + id);
        }
        taskRespository.deleteById(id);
    }


}
