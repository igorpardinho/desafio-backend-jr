package com.desafiobackendjr.service;


import com.desafiobackendjr.entity.Todo;
import com.desafiobackendjr.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll() {
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending()
        );
        return todoRepository.findAll(sort);
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return getAll();
    }


    public List<Todo> delete(UUID id) {
        todoRepository.deleteById(id);
        return getAll();
    }


}
