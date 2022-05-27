package bsi.projekt.todolist.service;

import bsi.projekt.todolist.model.CustomQuery;
import bsi.projekt.todolist.model.TodoItem;

import java.util.List;

public interface TodoItemCustom {

    List<TodoItem> query(CustomQuery dynamicQuery);

}
