import { createAsyncThunk, createSlice, current } from "@reduxjs/toolkit";

/*
NAME: hexArr
PARAMATERS: size
PURPOSE: This function generates an array of objects with q,r,s, and pattern values
*/
const hexArr = (size) => {
  let hexCordsArr = [];
  hexCordsArr.push({q:0,r:0,s:0,pattern:"cat"});
  for (let i = size * -1; i <= size; i++) {
    let x = i <= 0 ? size : -1 * size;
    let y = -1 * (x + i);

    let start = x > y ? y : x;
    let end = x > y ? x : y;

    for (let j = start, k = end; j <= end; j++, k--) {
      hexCordsArr.push({ q: i, r: j, s: k, pattern: "yellow"});
    }
  }
    //This is being tested to see if this position can be hard coded at generation
   
  return hexCordsArr;
};

//This is the default state the redux store uses. This is used even before the user selects a size.
const initialState = { grid: hexArr(3), size: 3, difficulty: "Easy" };

/*
NAME: setSizeRequest
PARAMATERS: size
PURPOSE: This function calls our backend api and tells them the size of the board
*/
export const setSizeRequest = createAsyncThunk(
  "setSizeRequest",
  async (size) => {
    const getReq = `http://localhost:8080/aicontroller/setboardsize?size=${size}`;
    const response = await fetch(getReq);
  }
);

/*
NAME: setDifficultyRequest
PARAMATERS: difficulty
PURPOSE: This function calls our backend api and tells them the game difficulty
*/
export const setDifficultyRequest = createAsyncThunk(
  "setDifficultyRequest",
  async (difficulty) => {
    const getReq = `http://localhost:8080/aicontroller/setdifficulty?difficulty=${difficulty}`;
    const response = await fetch(getReq);
  }
);

/*
NAME: addWallRequest
PARAMATERS: wallCords
PURPOSE: This function calls our backend api and tells them where the user is placing a wall
PRECONDITION: The user has selected a wall
*/
export const addWallRequest = createAsyncThunk(
  "addWallRequest",
  async (wallCords) => {
    const getReq = `http://localhost:8080/aicontroller/addwall?q=${wallCords.q}&r=${wallCords.r}&s=${wallCords.s}`;
    const response = await fetch(getReq);
  }
);

/*
NAME: getCatRequest
PURPOSE: This function calls our backend api and asks for the cats location
*/
export const getCatRequest = createAsyncThunk("getCatRequest", async () => {
  const getReq = "http://localhost:8080/aicontroller/getagentlocation";
  const response = await fetch(getReq);
  return response.json();
});

export const getCatRequestOnly = createAsyncThunk("getCatRequestonly", async () => {
  const getReq = "http://localhost:8080/aicontroller/getagentlocationonly";
  const response = await fetch(getReq);
  return response.json();
});




//The grid slice variable handles non-async actions the user dispatches
export const gridSlice = createSlice({
  name: "gird",
  initialState:{diff:"Easy"},
  reducers: {
    /*
    NAME: changeBlack
    PARAMETERS: grid, action
    PURPOSE: This function changes an individual tile in the redux store to black.
    */
    changeBlack: (grid, action) => {
      const { q, r, s } = { ...action.payload };
      const newGrid = grid.grid.map((gridEl) =>
        gridEl.q === q && gridEl.r === r && gridEl.s === s
          ? { q: q, r: r, s: s, pattern: null }
          : gridEl
      );
      return { grid: newGrid, size: grid.size, difficulty: grid.difficulty};
    },

    /*
    NAME: changeCat
    PARAMETERS: grid, action
    PURPOSE: This function changes an individual tile in the redux store to the cat image.
    */
    changeCat: (grid, action) => {
      const { q, r, s } = { ...action.payload };
      const newGrid = grid.grid.map((gridEl) =>
        gridEl.q == q && gridEl.r == r && gridEl.s == s
          ? { q: q, r: r, s: s, pattern: "cat" }
          : gridEl
      );
      return { grid: newGrid, size: grid.size, difficulty: grid.difficulty};
    },
    //This is where we would change a grid slice back to yello
    changeYello: (grid, action) => {
      const { q, r, s } = { ...action.payload };
      const newGrid = grid.grid.map((gridEl) =>
        gridEl.q == q && gridEl.r == r && gridEl.s == s
          ? { q: q, r: r, s: s, pattern: "yellow" }
          : gridEl
      );
      return { grid: newGrid, size: grid.size, difficulty: grid.difficulty};
    },
    //This is a test not complete
    initializeDiff: (state, action) => {
      state.difficulty=action.payload
    },

    /*
    NAME: initializeBoard
    PARAMETERS: grid, action
    PURPOSE: This function initializes the redux store based on the size given.
    */
    
    initializeBoard: (grid, action) => {
      const size = parseInt(action.payload[0]);
      const difficulty = (action.payload[1]);
      return { grid: hexArr(size), size: size, difficulty: difficulty};

    },
  },
});

// Action creators are generated for each case reducer function
export const { changeBlack, changeCat, changeYello, initializeBoard, initializeDiff } = gridSlice.actions;

export default gridSlice.reducer;
