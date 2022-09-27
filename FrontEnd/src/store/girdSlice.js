import { createSlice, current } from "@reduxjs/toolkit";

const hexArr = (size) => {
  let hexCordsArr = [];

  for (let i = size * -1; i <= size; i++) {
    let x = i <= 0 ? size : -1 * size;
    let y = -1 * (x + i);

    let start = x > y ? y : x;
    let end = x > y ? x : y;

    for (let j = start, k = end; j <= end; j++, k--) {
      hexCordsArr.push({ q: i, r: j, s: k, pattern: "yellow" });
    }
  }
  return hexCordsArr;
};

const initialState = hexArr(3);

export const gridSlice = createSlice({
  name: "gird",
  initialState,
  reducers: {
    changeBlack: (grid, action) => {
      const { q, r, s } = { ...action.payload };
      return grid.map((gridEl) =>
        gridEl.q === q && gridEl.r === r && gridEl.s === s
          ? { q: q, r: r, s: s, pattern: null }
          : gridEl
      );
    },

    changeCat: (grid, action) => {
      const { q, r, s } = { ...action.payload };
      return grid.map((gridEl) =>
        gridEl.q === q && gridEl.r === r && gridEl.s === s
          ? { q: q, r: r, s: s, pattern: "cat" }
          : gridEl
      );
    },
  },
});

// Action creators are generated for each case reducer function
export const { changeBlack, changeCat } = gridSlice.actions;

export default gridSlice.reducer;
