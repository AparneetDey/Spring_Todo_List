package com.spring.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.todo.model.TodosModel;
import com.spring.todo.service.TodosService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



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
    
    @GetMapping("/{id}")
    public ResponseEntity<TodosModel> getTodo(@PathVariable  Integer id) {
        TodosModel todo = service.findTodoById(id).get();
        HttpStatus status = HttpStatus.ACCEPTED;
        return new ResponseEntity<TodosModel>(todo, status);
    }
    
}
