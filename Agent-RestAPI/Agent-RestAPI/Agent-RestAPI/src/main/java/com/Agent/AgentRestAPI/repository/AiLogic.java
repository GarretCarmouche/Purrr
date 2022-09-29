package com.Agent.AgentRestAPI.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.Agent.AgentRestAPI.model.Agent;
import com.Agent.AgentRestAPI.model.Board;
import com.Agent.AgentRestAPI.model.Wall;

@Component
public class AiLogic 
{
    private Agent cat;
    private HashMap<String,Agent> wallList = new HashMap<>();
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


public Map<String, String> getAgentLocation() {
    HashMap<String, String> map = new HashMap<>();
    map.put("q", cat.getQ());
    map.put("r", cat.getR());
    map.put("s", cat.getS());
    return map;
}


//Add wall to list of walls
public void addWall(String key,Agent wall)
{
    
    wallList.put(key,wall);

}



public Map<String,Agent> getAllWalls()
{
    return wallList;

}


//set new location
public void moveAgent( Agent newLocation)
{
    cat = newLocation;

}








}