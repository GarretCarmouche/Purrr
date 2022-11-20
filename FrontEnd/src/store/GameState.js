import { createSlice, CreateSliceOptions } from "@reduxjs/toolkit";

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