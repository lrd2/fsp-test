package bsi.projekt.todolist.controller;

import bsi.projekt.todolist.model.TodoItem;
import bsi.projekt.todolist.model.TodoItemPostgres;
import bsi.projekt.todolist.service.OracleTodoService;
import bsi.projekt.todolist.service.TodoItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.execon.fsp.core.FspRequest;
import pl.execon.fsp.core.FspResponse;

@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
@AllArgsConstructor
public class TodoController {

    private final TodoItemService service;

    private final OracleTodoService todoService;

    @PostMapping()
    public TodoItem createToDo(@RequestBody TodoItem toDoItem) {
        return service.createToDo(toDoItem);
    }

    @PostMapping("/fsp")
    public FspResponse<TodoItem> findFsp(@RequestBody FspRequest fspRequest) {
        return service.findFsp(fspRequest);
    }

    @GetMapping
    public FspResponse<TodoItemPostgres> getAllToDos() {
        return todoService.get();
    }
    @PostMapping("/oracle")
    public FspResponse<TodoItemPostgres> getAllToDosOracle(@RequestBody FspRequest fspRequest) {
        return todoService.getOracle(fspRequest);
    }

    @DeleteMapping
    public void removeToDoItem(@RequestParam String id) {
        service.removeToDoItem(id);
    }

    @PutMapping
    public void updateToDoItem(@RequestBody TodoItem item) {
        service.updateToDoItem(item);
    }
}
