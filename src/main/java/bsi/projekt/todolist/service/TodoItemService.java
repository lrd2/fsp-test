package bsi.projekt.todolist.service;

import bsi.projekt.todolist.model.CustomQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoItemService {

    private final TodoItemRepository repository;

    public bsi.projekt.todolist.model.TodoItem createToDo(bsi.projekt.todolist.model.TodoItem toDoItem) {
        bsi.projekt.todolist.model.TodoItem savableToDo = bsi.projekt.todolist.model.TodoItem.builder()
                .text(toDoItem.getText())
                .createdDate(LocalDateTime.now())
                .build();
        return repository.save(savableToDo);
    }

    public List<bsi.projekt.todolist.model.TodoItem> getAllToDos() {
        return repository.query(new CustomQuery("abc"));
    }

    public void removeToDoItem(String id) {
        repository.deleteById(id);
    }

    public void updateToDoItem(bsi.projekt.todolist.model.TodoItem item) {
        bsi.projekt.todolist.model.TodoItem toDoItem = repository.findById(item.getId())
                .orElseThrow(IllegalArgumentException::new);
        toDoItem.setText(item.getText());
        toDoItem.setCompleted(item.isCompleted());
        repository.save(toDoItem);
    }

}
