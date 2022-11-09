import React from "react";
import { Hexagon } from "react-hexgrid";
import { useDispatch, useSelector } from "react-redux";
import { changeBlack,getCatRequestOnly, changeYello, addWallRequest } from "../store/girdSlice";




/*
NAME: HexagonalTile
PARAMATERS: q,r,s coordinates
PURPOSE: This function returns a react component representing an individual tile
PRECONDITION: The user has selected a size and a difficulty
*/
const HexagonTile = ({ q, r, s }) => {
  //The tile variable selects the tile corresponding to our q,r,s coordinates from our redux store
  const tile = useSelector((state) =>
    state.grid.grid.filter(
      (gridEl) => gridEl.q === q && gridEl.r === r && gridEl.s === s
    )
  );

  //The dispatch variable enables us to interact with our redux store by dispatching actions
  const dispatch = useDispatch();


  const handleCatLastMove = async () => {
    let val = await dispatch(getCatRequestOnly()).unwrap();
    dispatch(changeYello(val));
  };

  /*
  NAME: changeColor
  PURPOSE: This function changes the user tile to black, 
  and dispatches an action to let our backend know what tile was selected, and
  */
  const changeColor = () => {
    const gridId = { q: q, r: r, s: s };
    dispatch(changeBlack(gridId));
    const req = async () => {
      await dispatch(addWallRequest(gridId)).unwrap();
    };
    req();
  };

  //This return statement is what is actually rendered by the component
  return (
    <>
      {tile.pattern === null ? (
        <Hexagon q={q} r={r} s={s} onClick={() => changeColor()} />
      ) : (
        <Hexagon
          q={q}
          r={r}
          s={s}
          fill={tile[0].pattern}
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
