import React from "react";
import {
  HexGrid,
  Layout,
  Hexagon,
  Text,
  Pattern,
  Path,
  Hex,
} from "react-hexgrid";
import "../HexagonalGrid.css";
import HexagonTile from "./HexagonTile";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { setSizeRequest, getCatRequest, changeCat, changeYello } from "../store/girdSlice";
import { useNavigate } from "react-router-dom";

/*
This variable is an object that has a key used by the board state
and a link to the image that the tile needs to render corresponding to that key
*/

var runCounter = 2;
const patterns = [
  {
    id: "cat",
    link: "http://placekitten.com/g/1003/1003",
  },
  {
    id: "yellow",
    link: "https://www.bhphotovideo.com/images/images500x500/Savage_71_12_107_x_12yds_Background_129829.jpg",
  },
];

/*
NAME: setSize
PARAMATERS: size, integer
PURPOSE: This function returns a size for the tiles depending on the size of the board
PRECONDITION: The size of the board has been selected by the user
*/
const setSize = (size) => {
  return {x: 48/size, y: 48/size};
};

/*
NAME: HexagonalGrid
PARAMATERS: none
PURPOSE: This function returns a react component representing the game board
PRECONDITION: The user has selected a size and a difficulty
*/
const HexagonalGrid = () => {
  runCounter = runCounter - 1;
  //The dispatch variable enables us to interact with our redux store by dispatching actions
  const dispatch = useDispatch();

  //The hexArray variable grabs the current board from our redux store
  const hexArray = useSelector((state) => state.grid).grid;

  //The size variable grabs the board size from our redux store
  const size = useSelector((state) => state.grid).size;
  const difficulty = useSelector((state) => state.grid).difficulty;
  const boardRun = useSelector((state) => state.grid).boardRun


  //This is a react hook that is executed on the initial rendering of this component
  //It dispatches an action to our redux store that performs an api request
  useEffect(() => {
    const initRequest = async () => {
      await dispatch(setSizeRequest(size)).unwrap();
    };

    initRequest();
  }, []);

  /*
  NAME: handleCatMove
  PARAMATERS: none
  PURPOSE: This function dispatches an action to our redux store that requests the cats location
  PRECONDITION: The user has blocked a tile
  */
  const handleCatMove = async () => {
    let val = await dispatch(getCatRequest()).unwrap();
    dispatch(changeCat(val));
  };
  const navigate = useNavigate();
   const handleSubmitClick = () => {

     //dispatch(initializeBoard(size));
     navigate("/startup");
   };



   /*
  NAME: handleCatMove
  PARAMATERS: none
  PURPOSE: This function dispatches an action to our redux store that requests the cats location
  PRECONDITION: The user has blocked a tile
  */
  const handleCatLastMove = async () => {
    let val = await dispatch(getCatRequest()).unwrap();
    dispatch(changeYello(val));
  };





  //This return statement is what is actually rendered by this component
  //Subcomponents that are rendered have props passed into them that include values, strings,
  //or functions that map handle events
  return (
    <>
      <HexGrid
        width={1400}
        height={750}
        viewBox="-50 -100 200 200"
        onClick={() =>
        {
        
          handleCatMove()
        }}
      >
        <Layout
          size={setSize(size)}
          flat={true}
          spacing={1.05}
          origin={{ x: 100, y: 0 }}
        >
          {hexArray.map(({ q, r, s, difficulty, firstRun }) => (
            <HexagonTile q={q} r={r} s={s} difficulty = {"Easy"} firstRun = {runCounter === 1} key={q + " " + r + " " + s} />
          ))}
        </Layout>
        {patterns.map(({ id, link }) => (
          <Pattern id={id} link={link} key={id} />
        ))}
      </HexGrid>
      <div id ="ResetButton" className="Reset">
          <button type="button" id="submitBTN" onClick={handleSubmitClick}>
            Rest
          </button>
        </div>
    </>

  );
};

export default HexagonalGrid;
