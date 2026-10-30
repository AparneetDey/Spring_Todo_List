package com.spring.todo.service;

import org.springframework.stereotype.Service;

import com.spring.todo.model.TodosModel;
import com.spring.todo.repository.TodosRepository;

@Service 
public class TodosService {
    private final TodosRepository todosRepository;

    TodosService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    public TodosModel saveOrUpdate(TodosModel todo) {
        return todosRepository.save(todo);
    }
}
