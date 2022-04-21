package bsi.projekt.todolist.service;

import bsi.projekt.todolist.model.TodoItem;
import bsi.projekt.todolist.repository.TodoItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TodoItemService {

    private final TodoItemRepository repository;

    public TodoItem createToDo(TodoItem toDoItem) {
        TodoItem savableToDo = TodoItem.builder()
                .id(UUID.randomUUID().toString())
                .text(toDoItem.getText())
                .completed(false)
                .createdDate(LocalDateTime.now())
                .build();
        return repository.save(savableToDo);
    }

    public List<TodoItem> getAllToDos(String id) {
        return repository.findAll();
    }

    public void removeToDoItem(String id) {
        repository.deleteById(id);
    }

    public void updateToDoItem(String id, TodoItem item) {
        TodoItem toDoItem = repository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        toDoItem.setText(item.getText());
        toDoItem.completed(item.isCompleted());
    }
}
