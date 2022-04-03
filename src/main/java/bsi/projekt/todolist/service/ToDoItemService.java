package bsi.projekt.todolist.service;

import bsi.projekt.todolist.model.ToDoItem;
import bsi.projekt.todolist.repository.ToDoItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ToDoItemService {

    private final ToDoItemRepository repository;

    public ToDoItem createToDo(ToDoItem toDoItem) {
        ToDoItem savableToDo = ToDoItem.builder()
                .id(UUID.randomUUID().toString())
                .text(toDoItem.getText())
                .done(false)
                .createdDate(LocalDateTime.now())
                .build();
        return repository.save(savableToDo);
    }

    public List<ToDoItem> getAllToDos(String id) {
        return repository.findAll();
    }

    public void removeToDoItem(String id) {
        repository.deleteById(id);
    }

    public void updateToDoItem(String id, ToDoItem item) {
        ToDoItem toDoItem = repository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        toDoItem.setText(item.getText());
        toDoItem.setDone(item.isDone());
    }
}
