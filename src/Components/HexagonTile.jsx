import React from "react";
import { useState } from "react";
import { Hexagon } from "react-hexgrid";

const HexagonTile = ({ q, r, s, pattern }) => {
  const { pattern, setPattern } = pattern ? useState(null) : useState(pattern);

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
