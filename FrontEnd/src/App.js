import {
  HexGrid,
  Layout,
  Hexagon,
  Text,
  Pattern,
  Path,
  Hex,
} from "react-hexgrid";
import "./App.css";
import HexagonalGrid from "./Components/HexagonalGrid";
import StartUp from "./Components/StartUpScreen";
import { BrowserRouter as Router, Route, Switch} from 'react-router-dom';

function App() {
  
  return (
    <Router>
      <Switch>
        <Route path="/">
          <StartUp/>
        </Route>
        <Route path="/Game">
          <HexagonalGrid size={5} />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
