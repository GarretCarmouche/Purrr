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
  //<HexagonalGrid size={5} />,
  <StartUp/>
  );
}

export default App;
