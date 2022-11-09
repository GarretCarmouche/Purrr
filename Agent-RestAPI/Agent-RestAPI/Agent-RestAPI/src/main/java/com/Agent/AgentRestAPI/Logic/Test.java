package com.Agent.AgentRestAPI.Logic;
import com.Agent.AgentRestAPI.model.Agent;

public class Test extends AiLogic{

    public static void main(String[] args){

        Test testCat = new Test();
        Agent newLocation  = new Agent();
        System.out.println("Testing Begin");

        newLocation = testCat.getNextLocation();
        newLocation = testCat.getNextLocation();
        newLocation = testCat.getNextLocation();
        
        System.out.println("Agent Location : " + newLocation);
    }
}
