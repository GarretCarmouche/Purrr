package com.Agent.AgentRestAPI.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.Agent.AgentRestAPI.model.Agent;
import com.Agent.AgentRestAPI.model.Board;

@Component
public class AiLogic 
{
    private Agent cat;
    private Board gameBoard= null;// Just temporary until someone works on board class



public AiLogic()
{
    cat = new Agent();
    gameBoard =new Board();
}

/* 
public String[] getCurrentLocation()
{
    String[] currentLocation= {cat.getQ(),cat.getR(),cat.getS()};
    return currentLocation;
}
*/



//test json mapping
public Map<String, String> getAgentLocation() {
    HashMap<String, String> map = new HashMap<>();
    map.put("q", cat.getQ());
    map.put("r", cat.getR());
    map.put("s", cat.getS());
    return map;
}




//test json mapping
public Map<String, String> sayHello() {
    HashMap<String, String> map = new HashMap<>();
    map.put("key", "value");
    map.put("foo", "bar");
    map.put("aa", "bb");
    return map;
}

//set new location
public boolean moveCat(String q,String r,String s)
{
    cat.setQ(q);
    cat.setR(r);
    cat.setS(s);
    return true;

}





}