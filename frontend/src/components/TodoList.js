import React, {useEffect, useState} from "react";
import TodoForm from "./TodoForm";
import Todo from "./Todo";
import axios from "axios";

const baseUrl = "http://localhost:8080"

function TodoList() {
    const [todos, setTodos] = useState([])

    useEffect( () => {
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

    return (
        <div className='todo-list'>
            <TodoForm onSubmit={addTodo}/>
            <Todo
                todos={todos}
            />
        </div>
    )
}

export default TodoList;
