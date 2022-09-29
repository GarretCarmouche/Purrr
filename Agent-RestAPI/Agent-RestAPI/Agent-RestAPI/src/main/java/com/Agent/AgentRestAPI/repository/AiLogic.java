package com.Agent.AgentRestAPI.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.Agent.AgentRestAPI.model.Agent;
import com.Agent.AgentRestAPI.model.Board;


@Component
public class AiLogic 
{
    private Agent cat;
    private Agent wall;
    private List<Agent> wallList = new ArrayList<>();
    private Board gameBoard= null;// Just temporary until someone works on board class



public AiLogic()
{  
    cat = new Agent();
    gameBoard =new Board();
}


//test json mapping
public Map<String, String> sayHello() {
    HashMap<String, String> map = new HashMap<>();
    map.put("key", "value");
    map.put("foo", "bar");
    map.put("aa", "bb");
    return map;
}


public Map<String, String> getCatLocation() {
    HashMap<String, String> map = new HashMap<>();
    map.put("id", cat.getID());
    map.put("q", cat.getQ());
    map.put("r", cat.getR());
    map.put("s", cat.getS());
    return map;
}


//Add wall to list of walls
public  void addWall(Agent wall)
{
    
    wallList.add(wall);

}

//set new location
public void moveCat(Agent newLocation)
{
    cat=newLocation;

}








}