import { createAsyncThunk, createSlice, current } from "@reduxjs/toolkit";

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

const initialState = { grid: hexArr(3), size: 3 };

export const setSizeRequest = createAsyncThunk(
  "setSizeRequest",
  async (size) => {
    const getReq = `http://localhost:8080/aicontroller/setboardsize?size=${size}`;
    const response = await fetch(getReq);
  }
);

export const addWallRequest = createAsyncThunk(
  "addWallRequest",
  async (wallCords) => {
    const getReq = `http://localhost:8080/aicontroller/addwall?q=${wallCords.q}&r=${wallCords.r}&s=${wallCords.s}`;
    const response = await fetch(getReq);
  }
);

export const getCatRequest = createAsyncThunk("getCatRequest", async () => {
  const getReq = "http://localhost:8080/aicontroller/getagentlocation";
  const response = await fetch(getReq);
  return response.json();
});

export const gridSlice = createSlice({
  name: "gird",
  initialState,
  reducers: {
    changeBlack: (grid, action) => {
      const { q, r, s } = { ...action.payload };
      const newGrid = grid.grid.map((gridEl) =>
        gridEl.q === q && gridEl.r === r && gridEl.s === s
          ? { q: q, r: r, s: s, pattern: null }
          : gridEl
      );
      return { grid: newGrid, size: grid.size };
    },

    changeCat: (grid, action) => {
      const { q, r, s } = { ...action.payload };
      const newGrid = grid.grid.map((gridEl) =>
        gridEl.q === q && gridEl.r === r && gridEl.s === s
          ? { q: q, r: r, s: s, pattern: "cat" }
          : gridEl
      );
      return { grid: newGrid, size: grid.size };
    },

    initializeBoard: (grid, action) => {
      const size = parseInt(action.payload);
      return { grid: hexArr(size), size: size };
    },
  },
});

// Action creators are generated for each case reducer function
export const { changeBlack, changeCat, initializeBoard } = gridSlice.actions;

export default gridSlice.reducer;
