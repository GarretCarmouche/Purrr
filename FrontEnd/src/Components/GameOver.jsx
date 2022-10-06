import React from "react";
import '../GameOverStyle.css'
import { useNavigate } from "react-router-dom";

/*
NAME: GameOver
PARAMATERS:     none
PURPOSE:        This function returns a react component representing the Game Over screen
PRECONDITION:   The game has ended and the redux and AI have been reset. This function is triggered by an API call, 
                notifying the system that the game has ended.
POSTCONDITION:  Application navigation is taken back to the startup screen should the user choose to play again.
*/
const GameOver = () =>{
    const navigate = useNavigate();

    const handlePlayAgain = () =>{
        navigate("/")
    }
     //This return statement is what is actually rendered by this component
    return (
        <div className="GOcontainer">
            <h1>Game Over</h1>
            <div className="PlayAgain"><button type="button" id="playAgainBTN" onClick={handlePlayAgain}>Play Again</button></div>
        </div>
    );
};
export default GameOver