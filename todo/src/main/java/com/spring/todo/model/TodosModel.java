package com.spring.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Todos")
public class TodosModel {
    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private boolean completed;

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescriptio() {
        return this.description;
    }

    public void getCompleted(boolean completed) {
        this.completed = completed;
    }
    public boolean getCompleted() {
        return this.completed;
    }
}
