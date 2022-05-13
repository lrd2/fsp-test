import React, {useState} from 'react';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faAdd} from '@fortawesome/free-solid-svg-icons'
import {Button, Form, Input, InputGroup} from 'reactstrap'

const TodoForm = (props) => {
    const [inputValue, setInputValue] = useState('');

    const handleSubmit = e => {
        e.preventDefault()
        props.onSubmit({
            text: inputValue
        });
        setInputValue('')
    }

    return (
        <Form className='todo-form' onSubmit={handleSubmit}>
            <InputGroup>
                <Input
                    type='text'
                    placeholder='Add a todo'
                    value={inputValue}
                    className='todo-input'
                    onChange={e => setInputValue(e.target.value)}
                />
                <Button type={"submit"}>
                    <FontAwesomeIcon icon={faAdd}/>
                </Button>
            </InputGroup>
        </Form>
    )
}

export default TodoForm
