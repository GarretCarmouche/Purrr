import { configureStore } from "@reduxjs/toolkit";
import gridReducer from "./girdSlice";
import boardReducer from "./GameState"

//The store variable is configured and exported here
export const store = configureStore({
  reducer: {
    grid: gridReducer,
    boardState: boardReducer,
  },
});
