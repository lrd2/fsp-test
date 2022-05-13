import './App.css';
import TodoList from "./components/TodoList";

function App() {
    return (
        <div className="todo-app">
            <span className={'todo-tittle'}>Co masz dziś do zrobienia✍️</span>
            <TodoList/>
        </div>
    );
}

export default App;
