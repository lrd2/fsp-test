package bsi.projekt.todolist.controller;

import bsi.projekt.todolist.model.ToDoItem;
import bsi.projekt.todolist.service.ToDoItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class ToDoController {

    private final ToDoItemService service;

    @PostMapping
    public ToDoItem createToDo(@RequestBody ToDoItem toDoItem) {
        return service.createToDo(toDoItem);
    }

    @GetMapping
    public List<ToDoItem> getAllToDos(@RequestParam String id) {
        return service.getAllToDos(id);
    }

    @DeleteMapping
    public void removeToDoItem(@RequestParam String id) {
        service.removeToDoItem(id);
    }

    @PutMapping
    public void updateToDoItem(@RequestParam String id, @RequestBody ToDoItem item) {
        service.updateToDoItem(id, item);
    }
}
