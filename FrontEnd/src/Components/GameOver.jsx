import React from "react";
import '../GameOverStyle.css'
import { useNavigate } from "react-router-dom";

const GameOver = () =>{
    const navigate = useNavigate();

    const handlePlayAgain = () =>{
        navigate("/")
    }
    return (
        <div className="GOcontainer">
            <h1>Game Over</h1>
            <div className="PlayAgain"><button type="button" id="playAgainBTN" onClick={handlePlayAgain}>Play Again</button></div>
        </div>
    );
};
export default GameOver