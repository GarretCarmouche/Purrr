import React from "react";
import "../startUpStyle.css";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { reset,gamerun, resetGame} from "../store/GameState";

/*
NAME: PlayerLost
PARAMATERS: none
PURPOSE: This function returns a react component representing the loss screen
POSTCONDITION: The screen will display, giving the player the option to reset the game
*/
const PlayerLost= () => {

  //Navigate allows us to change the path which allows us to change what the user sees
  const navigate = useNavigate();

  //The dispatch variable enables us to interact with our redux store by dispatching actions
  const dispatch = useDispatch();

  /*
  NAME: handleSubmitClick
  PURPOSE: Reset the game back to the startup screen
  PRECONDITION: The user clicks the reset button
  */
  const handleSubmitClick = async () => {

    dispatch(reset())
    console.log("Game Reset")
    navigate("/startup");
  };

  //This return statement is what is actually rendered by this component
  return (
    <div>
      <div className="main">
        <div className="Lost">
          <h1>You Lose :/</h1>
        </div>
        <div className="Reset">
          <button type="button" id="resetBTN" onClick={handleSubmitClick}>
            Reset
          </button>
        </div>
      </div>
    </div>
  );
};
export default PlayerLost