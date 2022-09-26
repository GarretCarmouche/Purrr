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

const hexArr = (size) => {
  let hexCordsArr = [];

  for (let i = size * -1; i <= size; i++) {
    let x = i <= 0 ? size : -1 * size;
    let y = -1 * (x + i);

    let start = x > y ? y : x;
    let end = x > y ? x : y;

    for (let j = start, k = end; j <= end; j++, k--) {
      hexCordsArr.push({ q: i, r: j, s: k });
    }
  }
  return hexCordsArr;
};

//Need to adjust viewbox based on the size of the board

const HexagonalGrid = ({ size }) => {
  const hexArray = hexArr(size);
  return (
    <>
      <HexGrid
        width={1400}
        height={750}
        viewBox="-50 -100 200 200"
        onClick={() => console.log("Clicked")}
      >
        <Layout
          size={{ x: 10, y: 10 }}
          flat={true}
          spacing={1.05}
          origin={{ x: 0, y: 0 }}
        >
          {hexArray.map(({ q, r, s }) => (
            <HexagonTile
              q={q}
              r={r}
              s={s}
              key={q + " " + r + " " + s}
              patt={patterns[1].id}
            />
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
