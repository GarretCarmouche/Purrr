import { createSlice,createAsyncThunk, CreateSliceOptions } from "@reduxjs/toolkit";


/*
NAME: resetGame
PARAMATERS: None
PURPOSE: To fetch the command reset from the AIController
RETURN: None
*/
export const resetGame = createAsyncThunk(
    "resetGame",
    async () => {
      const getReq = `http://localhost:8080/aicontroller/reset`;
      const response = await fetch(getReq);
    }
  );

  /*
NAME: pathAvailable
PARAMATERS: None
PURPOSE: To fetch the command checkGameStatus, which see if cat AI has a path to win
RETURN: boolean, status of game
*/
  export const pathAvailable = createAsyncThunk(
    "pathAvailable",
    async () => {
      const getReq = `http://localhost:8080/aicontroller/checkGameStatus`;
      const response = await fetch(getReq);
    }
  );
/*
NAME: boardStateSlice
PARAMATERS: None
PURPOSE: Allows us to keep track to the game state, whether our game is running or not
RETURN: None
*/
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