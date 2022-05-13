import React, {useEffect, useState} from "react";
import TodoForm from "./TodoForm";
import Todo from "./Todo";
import axios from "axios";

const baseUrl = "http://localhost:8080"

const TodoList = () => {
    const [todos, setTodos] = useState([])

    useEffect(() => {
        axios.get(`${baseUrl}/todo`)
            .then(response => setTodos(response.data))
    }, [])

    function getTodos() {
        axios.get(`${baseUrl}/todo`)
            .then(response => setTodos(response.data))
    }

    const addTodo = todo => {
        if (todo.text === "") {
            return
        }
        axios.post(`${baseUrl}/todo`, {
            text: todo.text
        }).then(() => getTodos())
    }

    const removeTodo = (id) => {
        axios.delete(`${baseUrl}/todo`, {
            params: {
                id: id
            }
        })
            .then(() => getTodos())
    }

    const editTodo = (todoItem, inputText) => {
        axios.put(`${baseUrl}/todo`, {
            id: todoItem.id,
            text: inputText,
            completed: todoItem.completed
        }).then(() => getTodos())
    }

    const updateTodo = (todoItem) => {
        todoItem.completed = !todoItem.completed
        axios.put(`${baseUrl}/todo`, {
            id: todoItem.id,
            text: todoItem.text,
            completed: todoItem.completed

        }).then(() => getTodos())
    }

    return (
        <div className='todo-list'>
            <TodoForm onSubmit={addTodo}/>
            <Todo
                todos={todos}
                removeTodo={removeTodo}
                updateTodo={updateTodo}
                editTodo={editTodo}
            />
        </div>
    )
}

export default TodoList;
