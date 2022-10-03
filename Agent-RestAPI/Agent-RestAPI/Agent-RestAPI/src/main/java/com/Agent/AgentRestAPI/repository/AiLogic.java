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
    for(int i = 1; i < wallList.size(); i++){
        Agent wall = wallList.get(i);
        if(wall.getQ() == location.getQ() && wall.getS() == location.getS() && wall.getR() == location.getR()){
            return true;
        }
    }
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

//Implementation of AI algorithm. Recursive, 3 move look ahead min/max?
public Agent getNextLocation(){

    Agent[] moves = new Agent[6];
    moves[0] = new Agent("1", cat.getQ(), cat.getR() -1, cat.getS() +1);
    moves[1] = new Agent("2", cat.getQ() +1, cat.getR() -1, cat.getS());
    moves[2] = new Agent("3", cat.getQ() +1, cat.getR(), cat.getS() -1);
    moves[3] = new Agent("4", cat.getQ(), cat.getR() +1, cat.getS() -1);
    moves[4] = new Agent("5", cat.getQ() -1, cat.getR() +1, cat.getS());
    moves[5] = new Agent("6", cat.getQ() -1, cat.getR(), cat.getS() +1);
    
    int maxWeight = Integer.MAX_VALUE;
    Agent maxMove = moves[0];
    for(int i = 0; i < moves.length-1; i++) {
        int weight = calcWeight(moves[i]);
        if(weight < maxWeight){
            maxWeight = weight;
            maxMove = moves[i];
        }
    }

    moveCat(maxMove);
    return maxMove;
}

public int calcWeight(Agent location){
    if(isCellBlocked(location)){
        return 1000;
    }
    
    int minDist = Math.min(location.getS(), location.getQ());
    minDist = Math.min(minDist,location.getR());
    return minDist;
}








}