//import logo from './logo.svg';
//import './App.css';

import { useState } from "react";

function App() {

  let [number, setNumber] = useState(0);

  return (
    <div className="App">
      <input type="button" value="-" 
              onClick={()=>{
                setNumber(number - 1);
              }}/>

      <input type="button" value="0"
              onClick={()=>{
                setNumber(0);
              }}/>

      <input type="button" value="+"
              onClick={()=>{
                setNumber(number + 1);
              }}/>

      <span>{number}</span>
    </div>
  );
}

export default App;
