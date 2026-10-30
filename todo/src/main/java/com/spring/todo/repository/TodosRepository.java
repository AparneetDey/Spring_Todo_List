package com.spring.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.todo.model.TodosModel;

public interface TodosRepository extends JpaRepository<TodosModel, Integer> {
    
}
