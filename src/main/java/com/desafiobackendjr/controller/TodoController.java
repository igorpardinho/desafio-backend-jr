package com.desafiobackendjr.controller;

import com.desafiobackendjr.dto.TodoDTO;
import com.desafiobackendjr.entity.Todo;
import com.desafiobackendjr.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAll());
    }

    @PostMapping("/todo")
    public ResponseEntity<List<Todo>> save(@RequestBody @Valid TodoDTO todoDTO) {
        var todo = new Todo();
        BeanUtils.copyProperties(todoDTO, todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todo));
    }
}
