import { useState } from "react";
import "./App.css";

function App() {

  let [color, setColor] = useState("black")

  let fontColor = null;

  if(color === "black" || color === "yellow") {
    fontColor = "black"
  } else {
    fontColor = "white"
  }

  return (
    <div className="App">
      
      <div>
        <a>색상 선택</a>
        
        <select onChange={(e)=>{
          setColor(e.target.value)
        }}>
          <option value="black">::색상선택::</option>
          <option value="red">빨강</option>
          <option value="blue">파랑</option>
          <option value="green">초록</option>
          <option value="yellow">노랑</option>
        </select>
      </div>

      <div className="box" style={{backgroundColor: color, color: fontColor}}>
        {color}
      </div>
    
    </div>
  );
}

export default App;
