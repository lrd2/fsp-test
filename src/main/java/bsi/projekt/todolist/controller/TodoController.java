package bsi.projekt.todolist.controller;

import bsi.projekt.todolist.model.TodoItem;
import bsi.projekt.todolist.service.TodoItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class TodoController {

    private final TodoItemService service;

    @PostMapping
    public TodoItem createToDo(@RequestBody TodoItem toDoItem) {
        return service.createToDo(toDoItem);
    }

    @GetMapping
    public List<TodoItem> getAllToDos() {
        return service.getAllToDos();
    }

    @DeleteMapping
    public void removeToDoItem(@RequestParam String id) {
        service.removeToDoItem(id);
    }

    @PutMapping
    public void updateToDoItem(@RequestParam String id, @RequestBody TodoItem item) {
        service.updateToDoItem(id, item);
    }
}
