import './index.css';
import Navbar from './compopnents/Navbar';

import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import routes from './routes';

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar/>

        <div>
          { routes.map( rou => {
            return (
              <Routes>
                <Route path={rou.path} element={ <rou.component/> }/>
              </Routes>
            )
          } ) }
        </div>
        
      </div>
    </Router>
  );
}

export default App;
