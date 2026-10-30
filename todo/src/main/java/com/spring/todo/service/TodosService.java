package com.spring.todo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.todo.model.TodosModel;
import com.spring.todo.repository.TodosRepository;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class TodosService {
    private final TodosRepository todosRepository;

    public TodosModel saveOrUpdate(TodosModel todo) {
        return todosRepository.save(todo);
    }

    public Optional<TodosModel> findTodoById(int id) {
        return todosRepository.findById(id);
    }
}
