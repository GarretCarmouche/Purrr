package com.Agent.AgentRestAPI.controller;
/*
 * File Name: AIController.java
 * Version: 1.0
 * Data: 10/08/2022
 * Purpose: Contains the endpoints the front end needs to call in order to pass/retrieve data to out AiLogic class
 * Invariants:
 */

import org.springframework.http.HttpStatus;
import java.util.Map;
import java.util.HashMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Agent.AgentRestAPI.Logic.AiLogic;
import com.Agent.AgentRestAPI.model.Agent;

@RestController
@RequestMapping("/aicontroller")
@CrossOrigin(origins = "http://localhost:3000")
public class AIController {
    private AiLogic catAi;
    /*
     * Name: AIController
     * Purpose: To create an instance of our AIController
     * Preconditions: none
     * Postconditions: Will assign an instance of AiLogic
     * Parma: catAi : An instance of the AiLogic class
     * Return: none
     */
    public AIController(AiLogic catAi) {
        this.catAi = catAi;

    }


    //Endpoint is being tested 
    @GetMapping("/reset")
    public void resetGame()
    {
        catAi.restGameInstance();
    }

    //Endpoint is being tested 
    @GetMapping("/checkGameStatus")
    public boolean checkGame()
    {
        return catAi.checkGame();
    }



    /*
     * Name: sayHello
     * Purpose: To test Api endpoint, seeing if a client is receiving the data in JSON format, test API Call
     * Preconditions: none
     * Postconditions: The user will recive configured JSON data for testing
     * Param: none
     * Return: cat.sayHello : a call to our AiLogic method to return it to the user
     * Get http://localhost:8080/aicontroller/test
     */
    @GetMapping("/test")
    public Map<String, String> sayHello() {
        return catAi.sayHello();
    }

    /*
     * Name: getCatLocation
     * Purpose: To get the location of the cat agent
     * Precondition: An instance of the cat agent must exist
     * Postcondition: The user will recive configured JSON data of the cat agents current location
     * Param: none
     * Return: returnMap : A Map object that will be configured to JSON for the client
     * Get http://localhost:8080/aicontroller/getagentlocation
     */

    @GetMapping("/getagentlocation")
    public Map<String, String> getCatLocation() {
        //return catAi.getCatLocation();

        try

        {
            Agent newLocation = catAi.getNextLocation();
            HashMap<String, String> returnMap = new HashMap<>();
            returnMap.put("q", ""+newLocation.getQ());
            returnMap.put("r", ""+newLocation.getR());
            returnMap.put("s", ""+newLocation.getS());
            return returnMap;
        }catch(Exception e)
        {
            Map<String, Object> map = catAi.getCatLocation();
            HashMap<String, String> returnMap = new HashMap<>();
            returnMap.put("q", ""+map.get("q"));
            returnMap.put("r", ""+map.get("r"));
            returnMap.put("s", ""+map.get("s"));
            return returnMap;
        }
        
    }

     /*
     * Name: getAgentLocationOnly
     * Purpose: The same as the above function, except when the frontend calls it the cat agent is unaffected
     * Precondition: An instance of the cat agent must exist
     * Postcondition: The user will recive configured JSON data of the cat agents current location
     * Param: none
     * Return: returnMap : A Map object that will be configured to JSON for the client
     * Get http://localhost:8080/aicontroller/getagentlocationonly
     */

    @GetMapping("/getagentlocationonly")
    public Map<String, Object> getCatLocationOnly() {
        return catAi.getCatLocation();
    }


    /*
     * Name: moveCat
     * Purpose: To move the cat agent to a new location
     * Precondition: An instance of the cat agent must exist
     * Postcondition: The cat agent will be moved to a new set of coordinates 
     * Param: q,r,s : a set of interger values repersneting the cats coordinates on the board
     * Return: void : none
     * GET http://localhost:8080/aicontroller/movecat
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/movecat")
    public void moveCat(@RequestParam int q, int r, int s) {
        Agent newCatLocation = new Agent();
        newCatLocation.setQ(q);
        newCatLocation.setR(r);
        newCatLocation.setS(s);
        catAi.moveCat(newCatLocation);
    }

    /*
     * Name: addWall
     * Purpose: To add a wall agent to our list of walls from the client
     * Precondition: An instance of the wallList must exist
     * Postcondition: The wallList will have gained a new wall agent by one, with coordinates q,r,s
     * Param: q,r,s : a set of interger values representing the cats coordinates on the board
     * Return: void : none
     * GET http://localhost:8080/aicontroller/addwall
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/addwall")
    public void addWall(@RequestParam int q, int r, int s) {
        Agent newAg = new Agent();
        newAg.setQ(q);
        newAg.setR(r);
        newAg.setS(s);
        catAi.addWall(newAg);
    }
    
    /*
     * Name: setBoardSize
     * Purpose: To set the board size so our backend can calculate final positions and states
     * Precondition: An instance of the board member must exist
     * Postcondition: The board member will have a new integer value of size more than 0
     * Param: size : An integer value for the board member
     * Return: void : none
     *GET http://localhost:8080/aicontroller/setboardsize
     */
    @GetMapping("/setboardsize")
    public void setBoardSize(@RequestParam int size) {
        catAi.setBoardSize(size);
    }

    /*
     * Name: setDifficulty
     * Purpose: To set the difficulty in the backend
     * Precondition: The difficulty is selected
     * Postcondition: The backend has received the difficulty
     * Param: difficulty : The difficulty the user selected in the frontend
     * Return: void : none
     *GET http://localhost:8080/aicontroller/setdifficulty
     */

    @GetMapping("/setdifficulty")
    public void setDifficulty(@RequestParam String difficulty) {
        catAi.setDifficulty(difficulty);
    }
    
}
