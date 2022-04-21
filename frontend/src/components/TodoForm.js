import React, {useState} from 'react';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faAdd} from '@fortawesome/free-solid-svg-icons'

function TodoForm(props) {
    const [inputValue, setInputValue] = useState('');

    const handleSubmit = e => {
        e.preventDefault()
        props.onSubmit({
            text: inputValue
        });
        setInputValue('')
    }

    return (
        <form className='todo-form' onSubmit={handleSubmit}>
            <input
                type='text'
                placeholder='Add a todo'
                value={inputValue}
                className='todo-input'
                onChange={e => setInputValue(e.target.value)}
            />
            <button type={"submit"}>
                <FontAwesomeIcon icon={faAdd}/>
            </button>
        </form>
    )
}

export default TodoForm
