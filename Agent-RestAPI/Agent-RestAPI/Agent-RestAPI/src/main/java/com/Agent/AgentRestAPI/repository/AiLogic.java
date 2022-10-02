package com.Agent.AgentRestAPI.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.Agent.AgentRestAPI.model.Agent;



@Component
public class AiLogic 
{
    private Agent cat;
    //private Agent wall;
    private List<Agent> wallList = new ArrayList<>();
    private int boardSize;
    



public AiLogic()
{  
    cat = new Agent();
    boardSize=0;
}

public void setBoardSize(int size)
{
    boardSize=size;
    System.out.println(getBoardSize());
}

public int getBoardSize()
{
    return boardSize;
}


//test json mapping
public Map<String, String> sayHello() {
    HashMap<String, String> map = new HashMap<>();
    map.put("key", "value");
    map.put("foo", "bar");
    map.put("aa", "bb");
    return map;
}

//Returns json of cats location
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
    System.out.println(wall.getQ() + wall.getR() + wall.getS());
    wallList.add(wall);

}

//set new location
public void moveCat(Agent newLocation)
{   System.out.println(newLocation.getQ()+newLocation.getR()+newLocation.getS());
    cat=newLocation;
}


public boolean isCellBlocked(Agent location){

        return false;
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