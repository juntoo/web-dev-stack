import Login from "./Login";
import {BrowserRouter, Route, Routes} from 'react-router-dom'
import Signup from "./Signup";
import MainComp from "./MainComp";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login/>}></Route>
          <Route path="/signup" element={<Signup/>}></Route>
          <Route path="/main_content" element={<MainComp/>}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
