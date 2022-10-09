package com.Agent.AgentRestAPI.controller;
/*
 * @name AIController
 * @author Alonso Montelongo
 * @version 1.0
 * @data 10/08/2022
 * @purpose Contains the endpoints the frontend needs to call in order to pass/retrive data to out AILogic class
 * @invariants Yes
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
     * @name AIController
     * @purpose To create an instance of our AIController
     * @preconditions none
     * @postconditions Will assign an instance of AiLogic
     * @parma catAi : An instance of the AiLogic class
     * @return none
     */
    public AIController(AiLogic catAi) {
        this.catAi = catAi;

    }
    /*
     * @name sayHello
     * @purpose To test Api endpoint, seeing if a client is reciving the data in Json format, test API Call
     * @preconditions none
     * @postconditions The user will recive configured Json data for testing
     * @param none
     * @return cat.sayHello : a call to our AiLogic method to return it to the user
     * Get http://localhost:8080/aicontroller/test
     */
    @GetMapping("/test")
    public Map<String, String> sayHello() {
        return catAi.sayHello();
    }
    /*
     * @name getCatLocation
     * @purpose To get the location of the cat agent
     * @precondition An instance of the cat agent must exist
     * @postcondition The user will recive configured Json data of the cat agents current location
     * @param none
     * @return returnMap : A Map object that will be configured to Json for the client
     * Get http://localhost:8080/aicontroller/getagentlocation
     */
    @GetMapping("/getagentlocation")
    public Map<String, String> getCatLocation() {
        //return catAi.getCatLocation();
        Agent newLocation = catAi.getNextLocation();
        HashMap<String, String> returnMap = new HashMap<>();
        returnMap.put("q", ""+newLocation.getQ());
        returnMap.put("r", ""+newLocation.getR());
        returnMap.put("s", ""+newLocation.getS());
        return returnMap;
    }
    /*
     * @name moveCat
     * @purpose To move the cat agent to a new location
     * @precondition An instance of the cat agent must exist
     * @postcondition The cat agent will be moved to a new set of corrdinates 
     * @param q,r,s : a set of interger values repersneting the cats corrdinates on the board
     * @return void : none
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
     * @name addWall
     * @purpose To add a wall agent to our list of walls from the client
     * @precondition An instance of the wallList must exist
     * @postcondition The wallList will have gained a new wall agent by one, with corrdinates q,r,s
     * @param q,r,s : a set of interger values repersneting the cats corrdinates on the board
     * @return void : none
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
     * @name setBoardSize
     * @purpose To set the board size where we would be able to manipulate data from
     * @precondition An instance of the board member must exsit
     * @postcondition The board member will have a new integer value of size more than 0
     * @param size : An integer value for the board member
     * @return void : none
     */
    // GET http://localhost:8080/aicontroller/setboardsize
    @GetMapping("/setboardsize")
    public void setBoardSize(@RequestParam int size) {
        catAi.setBoardSize(size);
    }
}
