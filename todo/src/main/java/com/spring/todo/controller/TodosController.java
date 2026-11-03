package com.spring.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.todo.model.TodosModel;
import com.spring.todo.service.TodosService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/api/v1/todo")
@RestController 
@AllArgsConstructor 
public class TodosController {
    private final TodosService service;
    
    @PostMapping("/")
    public ResponseEntity<TodosModel> saveOrUpdate(@RequestBody TodosModel todo) {
        TodosModel newTodo = service.saveOrUpdate(todo);
        HttpStatus status = HttpStatus.CREATED;
        
        return new ResponseEntity<TodosModel>(newTodo, status);
    }

    @GetMapping("/")
    public ResponseEntity<List<TodosModel>> getAllTodo() {
        List<TodosModel> todos = service.findAllTodos();
        HttpStatus status = HttpStatus.ACCEPTED;
        return new ResponseEntity<List<TodosModel>>(todos, status);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TodosModel> getTodo(@PathVariable Integer id) {
        TodosModel todo = service.findTodoById(id).get();
        HttpStatus status = HttpStatus.ACCEPTED;
        return new ResponseEntity<TodosModel>(todo, status);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Integer id) {
        service.deleteTodoById(id);
        HttpStatus status = HttpStatus.ACCEPTED;
        return new ResponseEntity<String>("Task deleted successfully", status);
    }

    @PatchMapping("/{id}/completed")
    public ResponseEntity<TodosModel> toggleTodoComplete(@PathVariable Integer id) {
        TodosModel toggledTodo = service.toggleTodoComplete(id);
        HttpStatus status = HttpStatus.ACCEPTED;
        return new ResponseEntity<TodosModel>(toggledTodo, status);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<TodosModel>> getCompletedTodo() {
        List<TodosModel> completedTodo = service.findCompletedTodo(true);
        HttpStatus status = HttpStatus.ACCEPTED;
        return new ResponseEntity<List<TodosModel>>(completedTodo, status);
    }
    
    @GetMapping("/not-completed")
    public ResponseEntity<List<TodosModel>> getNotCompletedTodo() {
        List<TodosModel> notCompletedTodo = service.findCompletedTodo(false);
        HttpStatus status = HttpStatus.ACCEPTED;
        return new ResponseEntity<List<TodosModel>>(notCompletedTodo, status);
    }
    
}
