package com.Agent.AgentRestAPI.model;
/*
 * @name Agent
 * @autor Alonso Montelongo
 * @version 1.0
 * @data 10/8/2022
 * @purpose This class will model a agent in our game, in order to make manipulation of data easier
 * in this instance an agent may reprensent a cat or a wall
 * @invariants No
 */
public class Agent 
{   String id;
    int q;
    int r;
    int s;

    /*
     * @name Agent
     * @purpose To create an instance of an agent
     * @precondition none
     * @postcondition a new agent will be created
     * @param none
     * @return none
     */
    public Agent()
    {   id="1";
        q=0;
        r=0;
        s=0;
    }
    /*
     * @name Agnet
     * @purpose To create an instance of an agnet
     * @precondition none
     * @postcondition none
     * @param id,q,r,s :id =arbitrary string value needed to identify a specific agent, q = the q axis for our agent, r = the r axis for our agent, s = the s axis for our agent
     * @return none 
     */
    public Agent(String id,int q,int r,int s)
    {   this.id=id;
        this.q=q;
        this.r=r;
        this.s=s;
    }
    /*
     * @name getID
     * @purpose To get the Id of the agent
     * @precondition An agent instance must exist
     * @postcondition The user will receive the string value of the agent
     * @param none
     * @return id : The string value of id
     */
    public String getID()
    {
        return id;
    }
    /*
     * @name getQ
     * @purpose To get the current value of q
     * @precondition An agent instance must exist
     * @postcondition The user will receive the int value of the agent
     * @param none
     * @return q : The int value of q 
     */
    public int getQ()
    {
        return q;
    }
    /*
     * @name getR
     * @purpose To get the current value of r
     * @precondition An agent instance must exist
     * @postcondition The user will receive the int value of the agent
     * @param none
     * @return r : The int value of R 
     */
    public int getR()
    {
        return r;
    }
    /*
     * @name getS
     * @purpose To get the current value of S
     * @precondition An agent instance must exist
     * @postcondition The user will receive the int value of the agent
     * @param none
     * @return s : The int value of s
     */
    public int getS()
    {
        return s;
    }
    /*
     * @name setID
     * @purpose To set the value of id to a new value
     * @precondition An agent instance must exist
     * @postcondition The agent will have a new String value for id
     * @param id : an arbitrary String value 
     * @return void : none
     */
    public void setID(String id)
    {
        this.id=id;
    }
    /*
     * @name setQ
     * @purpose To set the value of q to a new value
     * @precondition An agent instance must exist
     * @postcondition The agent will have a new integer value for q
     * @param q : an integer value for q
     * @return void : none
     */
    public void setQ(int q)
    {
        this.q=q;
    }
    /*
     * @name setR
     * @purpose To set the value of r to a new value
     * @precondition An agent instance must exist
     * @postcondition The agent will have a new integer value for r
     * @param r : an integer value for r
     * @return void : none
     */
    public void setR(int r)
    {
        this.r=r;
    }
    /*
     * @name setS
     * @purpose To set the value of S to a new value
     * @precondition An agent instance must exist
     * @postcondition The agent will have a new integer value for s
     * @param s : an integer value for s
     * @return void : none
     */
    public void setS(int s)
    {
        this.s=s;
    }

}
