//import logo from './logo.svg';
//import './App.css';

import { useState } from "react";
import ToDo from "./components/ToDo";
import ToDoForm from "./components/ToDoForm";

function App() {

  const [toDoList, setToDoList] = useState([]);

  const addToDo = (e) => {
    setToDoList([...toDoList, e])
  }

  const toDoDel = (index) => {
    setToDoList( toDoList.filter((_, i)=>i !== index ) )
  }

  return (
    <div className="App">
      <h1>할 일 목록</h1>

      <ToDoForm addToDo={addToDo} />

      <ToDo toDoList={toDoList} toDoDel={toDoDel} />

    </div>
  );
}

export default App;
