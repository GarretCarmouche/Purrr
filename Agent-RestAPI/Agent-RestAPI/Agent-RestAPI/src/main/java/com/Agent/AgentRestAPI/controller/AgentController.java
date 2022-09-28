package com.Agent.AgentRestAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Agent.AgentRestAPI.model.Agent;

@RestController 
public class AgentController 
{

    @GetMapping("/agent")
    public Agent agent(@RequestParam(value="q",defaultValue ="0")String q,
    @RequestParam(value="r",defaultValue ="0")String r,
    @RequestParam(value="s",defaultValue ="0")String s)
    {
        return new Agent(q, r, s);

    }
    
}
