package com.Agent.AgentRestAPI.model;

public class Board 
{
    
    private String gameBoardmemberPlaceHolder;


    public Board()
    {
        gameBoardmemberPlaceHolder="this is a test for API calls I do not know how to make the board";
    }

    public String getBoard()
    {
        return gameBoardmemberPlaceHolder;
    }
}
