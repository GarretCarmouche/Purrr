package com.Agent.AgentRestAPI.model;

import ch.qos.logback.core.joran.conditional.ElseAction;

/*
 * File Name: Agent.java
 * Version: 1.0
 * Data: 10/8/2022
 * Purpose: This class will model a agent in our game, in order to make manipulation of data easier
 * in this instance an agent may reprensent a cat or a wall
 * Invariants: No
 */
public class Agent 
{   String id;
    int q;
    int r;
    int s;
    public boolean path =false;

    /*
     * Name: Agent
     * Purpose: To create an instance of an agent
     * Precondition: none
     * Postcondition: a new agent will be created
     * Param: none
     * Return: none
     */
    public Agent()
    {   id="1";
        q=0;
        r=0;
        s=0;
    }

    

    public String toString(){
        return ("" + this.getQ() + "," + this.getR() + "," + this.getS());
    }
    /*
     * Name: Agnet
     * Purpose: To create an instance of an agnet
     * Precondition: none
     * Postcondition: none
     * Param: id,q,r,s :id =arbitrary string value needed to identify a specific agent, q = the q axis for our agent, r = the r axis for our agent, s = the s axis for our agent
     * Return: none 
     */
    public Agent(String id,int q,int r,int s)
    {   this.id=id;
        this.q=q;
        this.r=r;
        this.s=s;
    }
    /*
     * Name: getID
     * Purpose: To get the Id of the agent
     * Precondition: An agent instance must exist
     * Postcondition: The user will receive the string value of the agent
     * Param: none
     * Return: id : The string value of id
     */
    public String getID()
    {
        return id;
    }
    /*
     * Name: getQ
     * Purpose: To get the current value of q
     * Precondition: An agent instance must exist
     * Postcondition: The user will receive the int value of the agent
     * Param: none
     * Return: q : The int value of q 
     */
    public int getQ()
    {
        return q;
    }
    /*
     * Name: getR
     * Purpose; To get the current value of r
     * Precondition: An agent instance must exist
     * Postcondition: The user will receive the int value of the agent
     * Param: none
     * Return: r : The int value of R 
     */
    public int getR()
    {
        return r;
    }
    /*
     * Name: getS
     * Purpose: To get the current value of S
     * Precondition: An agent instance must exist
     * Postcondition: The user will receive the int value of the agent
     * Param: none
     * Return: s : The int value of s
     */
    public int getS()
    {
        return s;
    }
    /*
     * Name: setID
     * Purpose: To set the value of id to a new value
     * Precondition: An agent instance must exist
     * Postcondition: The agent will have a new String value for id
     * Param: id : an arbitrary String value 
     * Return: void : none
     */
    public void setID(String id)
    {
        this.id=id;
    }
    /*
     * Name: setQ
     * Purpose: To set the value of q to a new value
     * Precondition: An agent instance must exist
     * Postcondition: The agent will have a new integer value for q
     * Param: q : an integer value for q
     * Return: void : none
     */
    public void setQ(int q)
    {
        this.q=q;
    }
    /*
     * Name: setR
     * Purpose: To set the value of r to a new value
     * Precondition: An agent instance must exist
     * Postcondition: The agent will have a new integer value for r
     * Param: r : an integer value for r
     * Return: void : none
     */
    public void setR(int r)
    {
        this.r=r;
    }
    /*
     * Name: setS
     * Purpose: To set the value of S to a new value
     * Precondition: An agent instance must exist
     * Postcondition: The agent will have a new integer value for s
     * Param: s : an integer value for s
     * Return: void : none
     */
    public void setS(int s)
    {
        this.s=s;
    }

    public void setPath(boolean path)
    {
        this.path =true;
    }

    /*
     * Name: equals
     * Purpose: To determine if two objects of Agent are equivilent
     * Precondition: An agent instance must exist
     * Postcondition: 
     * Param: o : An object
     * Return: boolean : If the two objects are equivilent
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Agent)){return false;}
        Agent agent = (Agent) o;
        return (agent.getQ() == this.getQ() && agent.getR() == this.getR() && agent.getS() == this.getS());
    }

    /*
     * Name: hashCode
     * Purpose: To provide a hash code for the Agent object
     * Precondition: An agent instance must exist
     * Postcondition: 
     * Param:
     * Return: int : A hash based on the q,r,s of the Agent
     */
    @Override
    public int hashCode(){
        String q,r,s;
        if(this.getQ() < 0){
            q = "9"+Math.abs(this.getQ());
        }else{ q = "0"+this.getQ();}
        if(this.getR() < 0){
            r = "9"+Math.abs(this.getR());
        }else{ r = "0"+this.getR();}
        if(this.getS() < 0){
            s = "9"+Math.abs(this.getS());
        }else{ s = "0"+this.getS();}
        String code = q+r+s;
        return Integer.parseInt(code);
    }

}
