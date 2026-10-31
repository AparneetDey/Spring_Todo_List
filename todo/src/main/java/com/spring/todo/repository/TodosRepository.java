package com.spring.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.todo.model.TodosModel;
import java.util.List;


public interface TodosRepository extends JpaRepository<TodosModel, Integer> {
    List<TodosModel> findByCompleted(boolean completed);
}
