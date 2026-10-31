package com.spring.todo.service;

import java.util.List;
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

    public List<TodosModel> findAllTodos() {
        return todosRepository.findAll();
    }

    public Optional<TodosModel> findTodoById(Integer id) {
        return todosRepository.findById(id);
    }

    public void deleteTodoById(Integer id) {
        todosRepository.deleteById(id);
    }

    public TodosModel toggleTodoComplete(Integer id) {
        return todosRepository.findById(id).map(existingTodo -> {
            if(existingTodo.getCompleted()) {
                existingTodo.setCompleted(false);
            } else {
                existingTodo.setCompleted(true);
            }

            return todosRepository.save(existingTodo);
        }).get();
    }

    public List<TodosModel> findCompletedTodo(boolean completed) {
        return todosRepository.findByCompleted(completed);
    }
}
