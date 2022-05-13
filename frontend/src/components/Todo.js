import React, {useState} from "react";
import {Button, Input} from "reactstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPen, faTrash, faXmark, faCheck} from '@fortawesome/free-solid-svg-icons'

const Todo = ({todos, removeTodo, updateTodo, editTodo}) => {

    const [edit, setEdit] = useState({
        isEditing: false,
        elementId: ''
    });

    const [inputText, setInputText] = useState('');

    return todos.reverse().map((todo, index) => (
            <div className='todo-row'
                 key={index}
            >
                {(edit.isEditing && edit.elementId === todo.id)
                    ? (
                        <>
                            <Input className={'edit-input'}
                                value={inputText}
                                onChange={e => setInputText(e.target.value)}
                            />
                            <div className={'todo-buttons'}>
                                <Button className={"btn-submit"} onClick={() => {editTodo(todo, inputText); setEdit({isEditing: false, elementId: ''})}}>
                                    <FontAwesomeIcon icon={faCheck}/></Button>
                                <Button className={"btn-edit"} onClick={() => setEdit({isEditing: false, elementId: ''})}>
                                    <FontAwesomeIcon icon={faXmark}/>
                                </Button>
                            </div>
                        </>
                    )
                    : (
                        <>
                            <span onClick={() => updateTodo(todo)}
                                  className={todo.completed ? 'todo-text crossed-line' : 'todo-text'}>
                                {todo.text}
                            </span>
                            <div className={'todo-buttons'}>
                                <Button className={"btn-remove"} onClick={() => removeTodo(todo.id)}>
                                    <FontAwesomeIcon icon={faTrash}/></Button>
                                <Button className={"btn-edit"} onClick={() => {setEdit({isEditing: true, elementId: todo.id}); setInputText(todo.text)}}>
                                    <FontAwesomeIcon icon={faPen}/>
                                </Button>
                            </div>
                        </>
                    )
                }
            </div>
        )
    )
}

export default Todo;
