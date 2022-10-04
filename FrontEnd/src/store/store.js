import { configureStore } from "@reduxjs/toolkit";
import gridReducer from "./girdSlice";

//The store variable is configured and exported here
export const store = configureStore({
  reducer: {
    grid: gridReducer,
  },
});
