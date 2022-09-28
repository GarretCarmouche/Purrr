package com.Agent.AgentRestAPI.repository;

import org.springframework.stereotype.Component;

import com.Agent.AgentRestAPI.model.Agent;
import com.Agent.AgentRestAPI.model.Board;

@Component
public class AiLogic 
{
    private Agent cat;
    private Board gameBoard= null;// Just temporary until someone works on board class



public AiLogic()
{
    cat = new Agent();
    gameBoard =new Board();
}


public String[] getCurrentLocation()
{
    String[] currentLocation= {cat.getQ(),cat.getR(),cat.getS()};
    return currentLocation;
}


//set new location
public boolean moveCat(String q,String r,String s)
{
    cat.setQ(q);
    cat.setR(r);
    cat.setS(s);
    return true;

}





}