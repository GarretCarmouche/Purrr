package com.Agent.AgentRestAPI.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Agent.AgentRestAPI.repository.AiLogic;

@RestController
@RequestMapping("/aicontroller")
public class AIController 
{
    private final AiLogic catAi;

    //This will create and instance of our agent
    public AIController(AiLogic catAi)
    {
        this.catAi= catAi;

    }

    /* 
    //Get http://localhost:8080/aicontroller
    @GetMapping
    public String[] getCurrentLocation()
    {
        return catAi.getCurrentLocation();
    }
    */

    //Get http://localhost:8080/aicontroller/getagentlocation
    @GetMapping("/getagentlocation")
    public Map<String, String> getAgentLocation()
    {
        return catAi.getAgentLocation();
    }




    //Get http://localhost:8080/aicontroller/test
    @GetMapping("/test")
    public Map<String, String> sayHello()
    {
        return catAi.sayHello();
    }


    
    
}
