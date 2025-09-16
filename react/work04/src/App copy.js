//import logo from './logo.svg';
//import './App.css';

import { useState } from "react";

function App() {

  let [name, setName] = useState('');

  let [emotion, setEmotion] = useState('');

  let msg = null;

  function hello(e) {
    let nameInput = document.getElementById("nameInput").value;
    setName(nameInput);
  }

  function selEmotion(e) {
    setEmotion(e.target.value);
  }

  if(emotion === "행복") {
    msg = "나는 행복합니다~";
  } else if(emotion === '슬픔') {
    msg = "ㅠㅠ"
  } else if(emotion === '화남') {
    msg = "ㅡㅡ"
  }

  return (
    <div className="App">
      <input type="text" placeholder="이름을 입력하세요" id="nameInput"/>
      <input type="button" value="인사하기" onClick={hello}/>
      <div>
        {name && (
          <h1>안녕하세요 {name}님! 오늘의 기분은 어떠신가요?</h1>
        ) }
      </div>
      <select onClick={selEmotion}>
        <option value=''>기분을 선택하세요</option>
        <option value='행복'>행복</option>
        <option value='슬픔'>슬픔</option>
        <option value='화남'>화남</option>
      </select>
      <h2>{msg}</h2>
    </div>
  );
}

export default App;
