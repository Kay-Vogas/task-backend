package com.software.Tarefas_Backend.controller;

import com.software.Tarefas_Backend.entities.Task;
import com.software.Tarefas_Backend.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/task")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        List<Task> list = taskService.findAll();
        return ResponseEntity.ok(list); // Retorna 200 OK + a lista
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        // O seu service usa .get(), que lança NoSuchElementException se não encontrar
        // Vamos capturar isso e retornar um 404 (Not Found)
        try {
            Task task = taskService.findById(id);
            return ResponseEntity.ok(task); // Retorna 200 OK + a task
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found
        }
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task newTask = taskService.createTask(task);
        // Retorna 201 Created (o padrão para criação) + a task criada
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task taskAtualizado) {
        // Seu service já lança uma RuntimeException (que podemos capturar)
        try {
            Task updatedTask = taskService.update(id, taskAtualizado);
            return ResponseEntity.ok(updatedTask); // Retorna 200 OK + a task atualizada
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o ID não existir
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // Seu service também lança RuntimeException aqui
        try {
            taskService.delete(id);
            // Retorna 204 No Content (padrão para delete com sucesso)
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o ID não existir
        }
    }

}
