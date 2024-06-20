package com.desafiobackendjr.controller;

import com.desafiobackendjr.dto.TodoDTO;
import com.desafiobackendjr.entity.Todo;
import com.desafiobackendjr.repository.TodoRepository;
import com.desafiobackendjr.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;
    private final TodoRepository todoRepository;

    public TodoController(TodoService todoService, TodoRepository todoRepository, TodoRepository todoRepository1) {
        this.todoService = todoService;
        this.todoRepository = todoRepository1;
    }

    @GetMapping("/todo")
    public ResponseEntity<List<Todo>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAll());
    }

    @PostMapping("/todo")
    public ResponseEntity<List<Todo>> save(@RequestBody @Valid TodoDTO todoDTO) {
        var todo = new Todo();
        BeanUtils.copyProperties(todoDTO, todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todo));
    }
    @PutMapping("/todo/{id}")
    public ResponseEntity<List<Todo>> update(@PathVariable("id")UUID id,@RequestBody @Valid TodoDTO todoDTO){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }
        var todo = optionalTodo.get();
        BeanUtils.copyProperties(todoDTO, todo);
         return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todo));
    }
    @DeleteMapping("/todo/{id}")
    public ResponseEntity<List<Todo>> delete(@PathVariable("id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(todoService.delete(id));
    }
}
