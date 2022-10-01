import React from "react";
import "../startUpStyle.css";
import { useState } from "react";
import { useDispatch } from "react-redux";
import { initializeBoard } from "../store/girdSlice";
import { useNavigate } from "react-router-dom";

const StartUp = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const [difficulty, setDifficulty] = useState(null);
  const [size, setSize] = useState(null);

  const handleDifficultyChange = (event) => {
    setDifficulty(event.target.value);
  };

  const handleSizeChange = (event) => {
    setSize(event.target.value);
  };

  const handleSubmitClick = () => {
    if (difficulty === null) return;
    if (size === null) return;

    dispatch(initializeBoard(size));
    navigate("/grid");
  };

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
            <input type="radio" name="Size" value={3} />
            Small
            <input type="radio" name="Size" value={5} />
            Regular
            <input type="radio" name="Size" value={7} />
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
