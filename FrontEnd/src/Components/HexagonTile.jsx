import React, { useState } from "react";
import { Hexagon } from "react-hexgrid";

const HexagonTile = ({ q, r, s, patt }) => {
  const [pattern, setPattern] = useState(patt);

  console.log(pattern);

  const changeColor = () => {
    setPattern();
    //Api request
    //{q: q, r: r, s: s}
  };

  return (
    <>
      {pattern === null ? (
        <Hexagon q={q} r={r} s={s} onClick={() => changeColor()} />
      ) : (
        <Hexagon
          q={q}
          r={r}
          s={s}
          fill={pattern}
          onClick={() => changeColor()}
        />
      )}
    </>
  );
};

export default HexagonTile;
