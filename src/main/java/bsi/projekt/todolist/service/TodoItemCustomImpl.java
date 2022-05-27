package bsi.projekt.todolist.service;

import bsi.projekt.todolist.model.CustomQuery;
import bsi.projekt.todolist.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.MongoRegexCreator;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class TodoItemCustomImpl implements TodoItemCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public TodoItemCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<TodoItem> query(CustomQuery dynamicQuery) {
        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
        if (dynamicQuery.getText() != null) {
            criteria.add(Criteria.where("text").regex("\\*a.*"));
        }
        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }
        return mongoTemplate.find(query, TodoItem.class);
    }
}
