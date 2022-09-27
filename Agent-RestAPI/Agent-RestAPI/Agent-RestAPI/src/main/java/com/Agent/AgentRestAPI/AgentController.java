package com.Agent.AgentRestAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
