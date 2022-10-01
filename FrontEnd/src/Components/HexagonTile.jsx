import React from "react";
import { Hexagon } from "react-hexgrid";
import { useDispatch, useSelector } from "react-redux";
import { changeBlack, addWallRequest } from "../store/girdSlice";

const HexagonTile = ({ q, r, s }) => {
  const tile = useSelector((state) =>
    state.grid.grid.filter(
      (gridEl) => gridEl.q === q && gridEl.r === r && gridEl.s === s
    )
  );
  const dispatch = useDispatch();

  const changeColor = () => {
    const gridId = { q: q, r: r, s: s };
    dispatch(changeBlack(gridId));
    const req = async () => {
      await dispatch(addWallRequest(gridId)).unwrap();
    };
    req();
  };

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
          onClick={() => changeColor()}
        />
      )}
    </>
  );
};

export default HexagonTile;
