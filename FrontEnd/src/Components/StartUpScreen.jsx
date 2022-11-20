import React from "react";
import "../startUpStyle.css";
import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { initializeBoard } from "../store/girdSlice";
import { useNavigate } from "react-router-dom";
import { reset,gamerun, resetGame} from "../store/GameState";

/*
NAME: StartUp
PARAMATERS: none
PURPOSE: This function returns a react component representing the startup screen
POSTCONDITION: The redux store is set to a starting board size corresponding to what the user selects
*/
const StartUp = () => {

  //Navigate allows us to change the path which allows us to change what the user sees
  const navigate = useNavigate();

  //The dispatch variable enables us to interact with our redux store by dispatching actions
  const dispatch = useDispatch();

  const boardRun = useSelector((state)=>state.boardState.boardRun)
  

  //The difficulty variable represents the difficulty selected by the user
  //Set difficulty is a function to change the difficulty value
  const [difficulty, setDifficulty] = useState(null);

  //The size variable represents the size of the board selected by the user
  //The set size represents the function to change the size of the board
  const [size, setSize] = useState(null);

  /*
  NAME: handleDifficultyChange
  PARAMATERS: event
  PURPOSE: This function changes the difficulty state whenever the user selects a difficulty
  PRECONDITION: The user changes the difficulty
  */
  const handleDifficultyChange = (event) => {
    setDifficulty(event.target.value);
  };

  /*
  NAME: handleSizeChange
  PARAMATERS: event
  PURPOSE: This function changes the size state whenever the user selects a size
  PRECONDITION: The user changes the size
  */
  const handleSizeChange = (event) => {
    setSize(event.target.value);
  };

  /*
  NAME: handleSubmitClick
  PURPOSE: This function dispatches an action initializing our redux store whenever a size, and difficulty have been selected.
            It also navigates the user to the place where the grid is rendered.
  PRECONDITION: The user clicks the submit button
  */
  const handleSubmitClick = async () => {
    if (difficulty === null) return;
    if (size === null) return;
    //Testing to see if AI cat agent reset
    let val = await dispatch(resetGame()).unwrap();




    dispatch(gamerun())
    console.log("This is the current state of the board at the start screen:",boardRun)
    dispatch(initializeBoard(size));
    navigate("/grid");
  };

  //This return statement is what is actually rendered by this component
  return (
    <div>
      <div className="main">
        <div className="Difficulty">
          <h1>Difficulty</h1>
          <form name="difficultyForm" onChange={handleDifficultyChange}>
            <input type="radio" name="Difficulty" value="Easy" />
            Easy
            <input type="radio" name="Difficulty" value="Medium" />
            Medium
            <input type="radio" name="Difficulty" value="Hard" />
            Hard
          </form>
        </div>
        <div className="Size">
          <h1>Size</h1>
          <form name="sizeForm" onChange={handleSizeChange}>
            <input type="radio" name="Size" value={5} />
            Small
            <input type="radio" name="Size" value={8} />
            Regular
            <input type="radio" name="Size" value={12} />
            Large
          </form>
        </div>
        <form />
        <div className="Submit">
          <button type="button" id="submitBTN" onClick={handleSubmitClick}>
            Submit
          </button>
        </div>
      </div>
    </div>
  );
};
export default StartUp;
