package com.Agent.AgentRestAPI.controller;

import org.springframework.http.HttpStatus;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Agent.AgentRestAPI.model.Agent;
import com.Agent.AgentRestAPI.repository.AiLogic;

@RestController
@RequestMapping("/aicontroller")
public class AIController 
{
    private AiLogic catAi;

    //This will create and instance of our agent
    public AIController(AiLogic catAi)
    {
        this.catAi= catAi;

    }

    /* 
    //Get http://localhost:8080/aicontroller
    @GetMapping("/getcurrentlocation")
    public String[] getCurrentLocation()
    {
        return catAi.getCurrentLocation();
    }
    */

    //Get http://localhost:8080/aicontroller/test
    @GetMapping("/test")
    public Map<String, String> sayHello()
    {
        return catAi.sayHello();
    }

        //Get http://localhost:8080/aicontroller/getagentlocation
    @GetMapping("/getagentlocation")
    public Map<String, String> getCatLocation()
    {
        return catAi.getCatLocation();
    }




    //Not tested, this should allow us to pass json of our cat at a new location
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/addwall")
    public void addWall(@RequestBody Agent newWall)
    {
        catAi.addWall(newWall);
    }



    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/movecat")
    public void moveCat(@RequestBody Agent newCatLocation)
    {
        catAi.moveCat(newCatLocation);
    }
    




    

    
    
}
