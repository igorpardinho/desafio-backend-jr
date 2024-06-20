package com.desafiobackendjr.service;

import com.desafiobackendjr.entity.Todo;
import com.desafiobackendjr.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTasks(){
        return todoRepository.findAll();
    }

    public Todo findByName(String name){
        return todoRepository.findBy(name);
    }


}
