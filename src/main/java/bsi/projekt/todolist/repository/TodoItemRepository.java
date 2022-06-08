package bsi.projekt.todolist.repository;

import bsi.projekt.todolist.model.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.execon.fsp.mongo.MongoFsp;

import java.util.List;

@Repository
public interface TodoItemRepository extends MongoRepository<bsi.projekt.todolist.model.TodoItem, String>, MongoFsp<TodoItem> {

    List<bsi.projekt.todolist.model.TodoItem> findAllById(String id);
}
