import { useState } from "react";
import "./App.css";

function App() {

  let [selColor, setSelColor] = useState('');

  let [mfont, setFont] = useState('');

  let changeBack = (e) => {
    let color = e.target.value;

    if( color === 'yellow' ) {
      setFont('black');
    } else{
      setFont('white');
    }

    setSelColor(color);

  }

  return (
    <div className="App">
    
      <a>색상 선택</a>
      
      <select onChange={ changeBack }>
        <option value="">::색상선택::</option>
        <option value="red">빨강</option>
        <option value="blue">파랑</option>
        <option value="green">초록</option>
        <option value="yellow">노랑</option>
      </select>

      <hr/>

      <div id="exam_div" style={{backgroundColor: selColor, color: mfont}}>
        {selColor}
      </div>
    
    </div>
  );
}

export default App;
