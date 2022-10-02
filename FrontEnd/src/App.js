import "./App.css";
import HexagonalGrid from "./Components/HexagonalGrid";
import StartUp from "./Components/StartUpScreen";
import GameOver from "./Components/GameOver";
import { Routes, Route, BrowserRouter } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<StartUp />} />
        <Route path="/grid" element={<HexagonalGrid />} />
        <Route path="/GameOver" element={<GameOver />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
