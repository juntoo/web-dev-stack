import { useState } from "react";

function App() {

  let [menu, setMenu] = useState(null)
  let content = null

  if(menu !== null) content = menu+"을 선택함"
  else content = "내용 없음"

  return (
    <div className="App">
      <Header></Header>
      <Select onChangeMenu={(menu)=>{
        setMenu(menu)
      }}></Select>
      <Article content={content}></Article>
    </div>
  );
}

function Header() {
  return (
    <header>
      <h1>메뉴 선택</h1>
    </header>
  );
}

function Select(props) {
  return (
    <div>
      <select onChange={(e)=>{
        props.onChangeMenu(e.target.value)
      }}>
        <option defaultValue={null} hidden>메뉴</option>
        <option>짜장</option>
        <option>짬뽕</option>
      </select>
    </div>
  );
}

function Article(props) {
  return (
    <div>
      <p>{props.content}</p>
    </div>
  );
}

export default App;
