//import logo from './logo.svg';
//import './App.css';

import { use, useState } from "react";

function App() {

  let [infos, setInfos] = useState([]);

  let [name, setName] = useState('');
  let [age, setAge] = useState('');

  let info = {};

  function addInfo() {
    info = {name: name, age: age};
    setName('');
    setAge('');

    setInfos([...infos, info]);
  }

  return (
    <div className="App">
      <input type="text" placeholder="이름을 입력하세요" value={name} 
             onChange={(e)=>{
              setName(e.target.value)
              console.log({name})
             }}/>
      <br/>

      <input type="text" placeholder="나이를 입력하세요" value={age} 
             onChange={(e)=>{
              setAge(e.target.value)
              console.log({age})
             }} />
      <input type="button" value="확인" onClick={addInfo}/>
      <table style={{border:"1px solid"}}>
        <tr>
          <th>이름</th>
          <th>나이</th>
        </tr>
        
        {
          infos.map( (i)=>( <tr><td>{i.name}</td><td>{i.age}</td></tr> ) )
        }
        
      </table>
    </div>
  );
}

export default App;
