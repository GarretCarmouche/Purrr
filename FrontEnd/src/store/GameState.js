import { createSlice,createAsyncThunk, CreateSliceOptions } from "@reduxjs/toolkit";



export const resetGame = createAsyncThunk(
    "resetGame",
    async () => {
      const getReq = `http://localhost:8080/aicontroller/reset`;
      const response = await fetch(getReq);
    }
  );


  export const pathAvailable = createAsyncThunk(
    "pathAvailable",
    async () => {
      const getReq = `http://localhost:8080/aicontroller/checkGameStatus`;
      const response = await fetch(getReq);
    }
  );

export const boardStateSlice = createSlice({ 
    name:"boardState", 
    initialState:{boardRun:2},
    reducers:{ 
        reset: (state)=>{
            state.boardRun =2;
        },
        gamerun: (state)=>{
            state.boardRun -=1;
        }
            }
        });
export const {reset,gamerun} = boardStateSlice.actions;

export default boardStateSlice.reducer;