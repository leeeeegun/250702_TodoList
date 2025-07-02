package com.example.todoapp.todo.service;

import com.example.todoapp.todo.entity.Todo;
import com.example.todoapp.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 할 일 전체 조회
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // 할 일 추가
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // 할 일 삭제
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    // 할 일 완료 체크 토굴
    public Todo toggleTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("지금 일을 찾을 수 없습니다."));
        todo.setDone(!todo.isDone());
        return todoRepository.save(todo);
    }
}
