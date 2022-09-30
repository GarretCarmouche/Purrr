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
import HexagonTile from "./HexagonTile";
import { useSelector } from "react-redux";

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

//Need to adjust viewbox based on the size of the board

//Large: 7
//Regular and Small 10
const setSize = (size) => {
  if (size === 7) return { x: 7, y: 7 };
  return { x: 10, y: 10 };
};

const HexagonalGrid = () => {
  const hexArray = useSelector((state) => state.grid).grid;
  const size = useSelector((state) => state.grid).size;
  return (
    <>
      <HexGrid
        width={1400}
        height={750}
        viewBox="-50 -100 200 200"
        onClick={() => console.log("Clicked")}
      >
        <Layout
          size={setSize(size)}
          flat={true}
          spacing={1.05}
          origin={{ x: 0, y: 0 }}
        >
          {hexArray.map(({ q, r, s }) => (
            <HexagonTile q={q} r={r} s={s} key={q + " " + r + " " + s} />
          ))}
        </Layout>
        {patterns.map(({ id, link }) => (
          <Pattern id={id} link={link} key={id} />
        ))}
      </HexGrid>
    </>
  );
};

export default HexagonalGrid;
