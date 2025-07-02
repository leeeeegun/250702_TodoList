package com.example.todoapp.todo.controller;

import com.example.todoapp.todo.entity.Todo;
import com.example.todoapp.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // 전체 할 일 조회
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // 새 할 일 추가
    @PatchMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    // 할 일 삭제
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    // 할 일 완료 여부 토굴
    @PatchMapping("/{id}/toggle")
    public void toggleTodo(@PathVariable Long id) {
        todoService.toggleTodo(id);
    }
}
