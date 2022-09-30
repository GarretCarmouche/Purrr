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
    //private Agent wall;
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


public Map<String, Object> getCatLocation() {
    HashMap<String, Object> map = new HashMap<>();
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

public boolean isCellBlocked(Agent location){

}

public char getNearestDistanceAxis(Agent currentLocation){
    if(Math.abs(currentLocation.getQ()) > Math.abs(currentLocation.getR()) && Math.abs(currentLocation.getQ()) > Math.abs(currentLocation.getS())){
        return 'q';
    }else if(currentLocation.getR() > currentLocation.getS()){
        return 'r';
    }else{
        return 's';
    }
}

public Agent getNextLocation(){
    char nearestAxis = getNearestDistanceAxis(cat);
    if(nearestAxis == 'q'){

    }else if(nearestAxis == 'r'){

    }else{

    }
    return new Agent();
}








}