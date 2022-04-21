import './App.css';
import TodoList from "./components/TodoList";

function App() {
    return (
        <div className="todo-app">
            <h1>What do you have to do today?</h1>
            <TodoList/>
        </div>
    );
}

export default App;
