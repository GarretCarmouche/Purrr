import { configureStore } from "@reduxjs/toolkit";
import gridReducer from "./girdSlice";

export const store = configureStore({
  reducer: {
    grid: gridReducer,
  },
});
