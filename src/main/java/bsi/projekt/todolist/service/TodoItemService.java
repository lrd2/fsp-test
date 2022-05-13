package bsi.projekt.todolist.service;

import bsi.projekt.todolist.model.TodoItem;
import bsi.projekt.todolist.repository.TodoItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoItemService {

    private final TodoItemRepository repository;

    public TodoItem createToDo(TodoItem toDoItem) {
        TodoItem savableToDo = TodoItem.builder()
                .text(toDoItem.getText())
                .createdDate(LocalDateTime.now())
                .build();
        return repository.save(savableToDo);
    }

    public List<TodoItem> getAllToDos() {
        return repository.findAll();
    }

    public void removeToDoItem(String id) {
        repository.deleteById(id);
    }

    public void updateToDoItem(TodoItem item) {
        TodoItem toDoItem = repository.findById(item.getId())
                .orElseThrow(IllegalArgumentException::new);
        toDoItem.setText(item.getText());
        toDoItem.setCompleted(item.isCompleted());
        repository.save(toDoItem);
    }
}
