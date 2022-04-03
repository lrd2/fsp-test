package bsi.projekt.todolist.repository;

import bsi.projekt.todolist.model.ToDoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoItemRepository extends MongoRepository<ToDoItem, String> {

    List<ToDoItem> findAllByAuthorId(String authorId);
}
