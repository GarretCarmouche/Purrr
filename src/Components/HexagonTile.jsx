import React from "react";
import { useState } from "react";
import { Hexagon } from "react-hexgrid";

const HexagonTile = ({ q, r, s, patt }) => {
  const { pattern, setPattern } = useState(patt);

  return (
    <>
      {pattern === null ? (
        <Hexagon q={q} r={r} s={s} />
      ) : (
        <Hexagon q={q} r={r} s={s} fill={pattern} />
      )}
    </>
  );
};

export default HexagonTile;
