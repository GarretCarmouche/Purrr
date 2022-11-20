import React from "react";
import { Hexagon } from "react-hexgrid";
import { useDispatch, useSelector } from "react-redux";
import { gamerun } from "../store/GameState";
import { changeBlack,getCatRequestOnly, changeYello, addWallRequest } from "../store/girdSlice";

var setBlack = false;
/*
NAME: HexagonalTile
PARAMATERS: q,r,s coordinates
PURPOSE: This function returns a react component representing an individual tile
PRECONDITION: The user has selected a size and a difficulty
*/
const HexagonTile = ({ q, r, s, difficulty, firstRun }) => {
  //The dispatch variable enables us to interact with our redux store by dispatching actions
  const dispatch = useDispatch();
  const boardRun = useSelector((state)=>state.boardState.boardRun)
  /*
  NAME: changeColor
  PURPOSE: This function changes the user tile to black, 
  and dispatches an action to let our backend know what tile was selected, and
  */
  const changeColor = () => {
    const gridId = { q: q, r: r, s: s };
    dispatch(gamerun())
    console.log("This is the current state of the board at the at tile:",boardRun)
    dispatch(changeBlack(gridId));
    const req = async () => {
      await dispatch(addWallRequest(gridId)).unwrap();
    };
    req();
  };

  //console.log(q,r,s);
  //console.log(firstRun);
  //console.log(difficulty);
  //The tile variable selects the tile corresponding to our q,r,s coordinates from our redux store
  if(firstRun){
    if(difficulty === "Easy"){
      setBlack = Math.random() > .9;
      if(setBlack){
        changeColor();
      }
    }else if(difficulty === "Medium"){
      setBlack = Math.random() > .9;
      if(setBlack){
        changeColor();
      }
    }else if(difficulty === "Hard"){
      setBlack = Math.random() > .9;
      if(setBlack){
        changeColor();
      }
    }
  }
  
  const tile = useSelector((state) =>
    state.grid.grid.filter(
      (gridEl) => gridEl.q === q && gridEl.r === r && gridEl.s === s
    )
  );


  const handleCatLastMove = async () => {
    let val = await dispatch(getCatRequestOnly()).unwrap();
    dispatch(changeYello(val));
  };

  //This return statement is what is actually rendered by the component

  var pattern = tile[0].pattern
  //console.log(pattern);
  //console.log(tile.pattern);
  //if(setBlack){pattern = null;}
  return (
    <>
      {tile.pattern === null ? (
        <Hexagon q={q} r={r} s={s} onClick={() => changeColor()} />
      ) : (
        <Hexagon
          q={q}
          r={r}
          s={s}
          fill={pattern}
          onClick={() => {
            
            handleCatLastMove()
            changeColor()
          }}
        />
      )}
    </>
  );
};

export default HexagonTile;
