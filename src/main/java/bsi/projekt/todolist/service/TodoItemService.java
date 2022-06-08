package bsi.projekt.todolist.service;

import bsi.projekt.todolist.model.TodoItem;
import bsi.projekt.todolist.repository.TodoItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.execon.fsp.core.FspRequest;
import pl.execon.fsp.core.FspResponse;

import java.time.LocalDateTime;

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

    public FspResponse<TodoItem> getAllToDos() {
        FspResponse<TodoItem> fsp = repository.findFsp(new FspRequest(), TodoItem.class);
        return fsp;
    }

    public FspResponse<TodoItem> findFsp(FspRequest request) {
        return repository.findFsp(request, TodoItem.class);
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
