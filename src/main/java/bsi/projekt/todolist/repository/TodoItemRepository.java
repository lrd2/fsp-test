package bsi.projekt.todolist.repository;

import bsi.projekt.todolist.model.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends MongoRepository<TodoItem, String> {

    List<TodoItem> findAllById(String id);
}
