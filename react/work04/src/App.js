//import logo from './logo.svg';
//import './App.css';

import { useState } from "react";

function App() {

  let [greet, setGreet] = useState('');

  function nameChange(e) {
    e.preventDefault();

    let name = e.target.myname.value;
    setGreet('안녕하세요 '+ name + "님, 오늘의 기분은?");
  }

  return (
    <div className="App">
      <form onSubmit={nameChange}>
        <input type="text" name="myname" placeholder="이름을 입력하세요" />
        <input type="submit" value="인사하기"/>
      </form>

      <p>{greet}</p>

      
      <MyMood></MyMood>
    </div>
  );
}

function MyMood() {

  let [msg, setMsg] = useState('');

  function moodChange(e) {

    let mood = e.target.value;

    if(mood === "행복") {
      setMsg('행복도르');
    }else if(mood === '슬픔') {
      setMsg('슬프도르');
    }else if(mood === '화남') {
      setMsg('화났도르');
    }else {
      setMsg('');
    } 
  }
  {/**기분을 선택하는 select태그 */}
  return (
    <div>
      <select onChange={moodChange}>
        <option value=''>기분을 선택하세요</option>
        <option value='행복'>행복</option>
        <option value='슬픔'>슬픔</option>
        <option value='화남'>화남</option>
      </select>

      <p>{msg}</p>
    </div>
  )
}

export default App;
