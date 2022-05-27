package bsi.projekt.todolist.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends MongoRepository<bsi.projekt.todolist.model.TodoItem, String>, TodoItemCustom {

    List<bsi.projekt.todolist.model.TodoItem> findAllById(String id);
}
