import "./App.css";
import HexagonalGrid from "./Components/HexagonalGrid";
import StartUp from "./Components/StartUpScreen";
import GameOver from "./Components/GameOver";
import PlayerWon from "./Components/PlayerWon";
import PlayerLost from "./Components/PlayerLost";
import { Routes, Route, BrowserRouter } from "react-router-dom";

/*
NAME: App
PURPOSE: This function returns a react component representing our application
*/
function App() {
  //The routing enables us to change what is rendered based on the URL.
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<StartUp />} />
        <Route path="/startup" element={<StartUp />} />
        <Route path="/grid" element={<HexagonalGrid />} />
        <Route path="/GameOver" element={<GameOver />} />
        <Route path="/PlayerWon" element={<PlayerWon />} />
        <Route path="/PlayerLost" element={<PlayerLost />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
