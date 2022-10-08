package com.Agent.AgentRestAPI.controller;
/*
 * @name AIController
 * @author Alonso Montelongo
 * @version 1.0
 * @data 10/08/2022
 * Contains the endpoints the frontend needs to call in order to pass/retrive data to out AILogic class
 * 
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
import com.Agent.AgentRestAPI.model.Agent;
import com.Agent.AgentRestAPI.repository.AiLogic;

@RestController
@RequestMapping("/aicontroller")
@CrossOrigin(origins = "http://localhost:3000")
public class AIController {
    private AiLogic catAi;

    // This will create and instance of our agent
    public AIController(AiLogic catAi) {
        this.catAi = catAi;

    }

    // Test API call
    // Get http://localhost:8080/aicontroller/test
    @GetMapping("/test")
    public Map<String, String> sayHello() {
        return catAi.sayHello();
    }

    // Test API call
    // Get http://localhost:8080/aicontroller/getagentlocation
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

    // GET http://localhost:8080/aicontroller/movecat
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/movecat")
    public void moveCat(@RequestParam int q, int r, int s) {
        Agent newCatLocation = new Agent();
        newCatLocation.setQ(q);
        newCatLocation.setR(r);
        newCatLocation.setS(s);
        catAi.moveCat(newCatLocation);
    }

    // GET http://localhost:8080/aicontroller/addwall
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/addwall")
    public void addWall(@RequestParam int q, int r, int s) {
        Agent newAg = new Agent();
        newAg.setQ(q);
        newAg.setR(r);
        newAg.setS(s);
        System.out.println(q);
        System.out.println(r);
        System.out.println(s);
        catAi.addWall(newAg);
    }

    // GET http://localhost:8080/aicontroller/setboardsize
    @GetMapping("/setboardsize")
    public void setBoardSize(@RequestParam int size) {
        catAi.setBoardSize(size);
    }
}
