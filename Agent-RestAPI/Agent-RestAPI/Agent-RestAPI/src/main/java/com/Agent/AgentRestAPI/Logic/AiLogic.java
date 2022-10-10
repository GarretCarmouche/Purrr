package com.Agent.AgentRestAPI.Logic;
/*
 * FileNaem: AiLogic.java
 * Author: Alonso Montelongo, Kile Soto, Garret Carmouche
 * Version: 1.0
 * Data: 10/08/2022
 * Purpose: Within this class we are able to set the game's enviorments and change the state of them.
 * Allowing us to have an enviorment that is constantly changing with the introducion of wall agents.
 * Here we also change the state of the cat agent by changing the location once a new wall agent is introduced to our enviorment
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.Agent.AgentRestAPI.model.Agent;


//This class annotation allows spring to manage the components being called in the controller class
@Component
public class AiLogic 
{
    private Agent cat;
    private List<Agent> wallList = new ArrayList<>();
    private int boardSize;
    


/*
 * Name: AiLogic
 * Purpose: Constructor, creates an instance of our AiLogic class
 * Precondition: none
 * Postcondition: An instance of a cat agent will be created, our walllist will be empty, and our boardSize will be set to zero
 * Param: none
 * Return: none
 */
public AiLogic()
{  
    cat = new Agent();
    boardSize=0;
}

/*
 * Name: setBoardSize
 * Purpose: Assign the board size for an instance of our object, should only be called once during runtime
 * Precondition: Instance of class must be created
 * Postcondition: Our boardSize will have a new value
 * Param: size An integer that will be the size of the board at the start of the game
 * Return void : none
 */
public void setBoardSize(int size)
{
    boardSize=size;
    System.out.println("Board Size : "+getBoardSize());
}

/*
 * Name: getBoardSize
 * Purpose: Will return the board size as an integer
 * Precondition: Instance of class must be created
 * Postcondition: Will return the value of the boards current size
 * Param: none
 * Return: boardSize :An integer value
 */
public int getBoardSize()
{
    return boardSize;
}


/*
 * Name: sayHello
 * Purpose: This call was created in order to test comunication between the our AIController class
 * Precondition: none this is a test
 * Postcondition: Will give the user a mapped object with preset values
 * Param: none
 * Return: map :A Map object with contains the key and values as string typed
 */
public Map<String, String> sayHello() {
    HashMap<String, String> map = new HashMap<>();
    map.put("key", "value");
    map.put("foo", "bar");
    map.put("aa", "bb");
    return map;
}

/*
 * Name: getCatLocation
 * Purpose: Will return the cats current location as Map object
 * Precondition: An instance of the cat agent must be created
 * Postcondition: The user will have the current location of the cat agent
 * Param: none
 * Return: map :The object will have the id and the q,r,s coordinates mapped out to the values the cat agent has at id,q,r,s 
 */
public Map<String, Object> getCatLocation() {
    HashMap<String, Object> map = new HashMap<>();
    map.put("id", cat.getID());
    map.put("q", cat.getQ());
    map.put("r", cat.getR());
    map.put("s", cat.getS());
    return map;
}


/*
 * Name: addWall
 * Purpose: Will add an agent that repersents a wall to the list of walls we currently have in wallList
 * Precondition: An instance of our wallList must be created
 * Postcondition: The wallList member will have increaed the number of agents in its list by one
 * Param: wall : wall is a agent that contains the coordinates of the wall placed by the user
 * Return: void :none
 */
public  void addWall(Agent wall)
{
    System.out.println("New Wall added location : "+wall.getQ()+" " + wall.getR()+" " + wall.getS());
    wallList.add(wall);

}

/*
 * Name: moveCat
 * Purpose: To set our cat agent to a new location
 * Precondition: An instance of our cat agent must exist
 * Postcondition: The cat agent will have new coordinates corisponding to the new agents q,r,s
 * Param: newLocation : This will be a new agent with diffrent coordinates
 * Return: void : none
 */
public void moveCat(Agent newLocation)
{   System.out.println("Cat New Location : "+newLocation.getQ()+" " + newLocation.getR()+" " + newLocation.getS());
    cat=newLocation;
}

/*
 * Name: isCellBlocked
 * Purpose: To see if the given location exists inside wallList
 * Precondition: The wallList must contain one agent 
 * Postcondition: Will let the user know if a wall exist in that location
 * Param: location : A agent with its own coordinates of q,r,s
 * Return: boolean : True for wall exist in our list ,else false
 */
public boolean isCellBlocked(Agent location){
    for(int i = 0; i < wallList.size(); i++){
        Agent wall = wallList.get(i);
        if(wall.getQ() == location.getQ() && wall.getS() == location.getS() && wall.getR() == location.getR()){
            return true;
        }
    }
    return false;
}


/*
 * Name: getNearestdistanceAxis
 * Purpose: To get the axis based on the currentLocation that is closest to the edge
 * Precondition: An instance of our cat agent must exist, and board size must be more than 0
 * Postcondition: User will know which axis currentLocation is closest to the edge on
 * Param: currentLocation :This will be a agent that contains its own coordinates q,r,s
 * Return: char : Will return the corresponding axis of our agent that value is the largest from its q,r,s
 */
public char getNearestDistanceAxis(Agent currentLocation){
    if(Math.abs(currentLocation.getQ()) > Math.abs(currentLocation.getR()) && Math.abs(currentLocation.getQ()) > Math.abs(currentLocation.getS())){
        return 'q';
    }else if(currentLocation.getR() > currentLocation.getS()){
        return 'r';
    }else{
        return 's';
    }
}

/*
 * Name: getNextLocation
 * Purpose: To calculate a new location for the cat agent to move to based on its current location
 * Precondition: An instance of our cat agent must exist, and board size must be more than 0
 * Postcondition: The cat agent will have a new location corresponding to the agent maxMove
 * Param: none
 * Return: maxMove : A new agent with the calculated max weight
 */
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

/*
 * Name: calcWeight
 * Purpose: Calculate a weight for the given location based on pre-determined metrics
 * Precondition: Agent must not have corrdinates 0,0,0
 * Postcondition: User will know the weight of the location
 * Param: location : An agent withs its own corrdinates q,r,s
 * Return: minDist : The lowest int value between the location agent axis q,r,s
 */
public int calcWeight(Agent location){
    if(isCellBlocked(location)){
        return 1000;
    }
    
    int minDist = Math.min(location.getS(), location.getQ());
    minDist = Math.min(minDist,location.getR());
    return minDist;
}








}
