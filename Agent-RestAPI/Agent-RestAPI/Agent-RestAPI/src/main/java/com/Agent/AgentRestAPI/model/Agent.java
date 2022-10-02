package com.Agent.AgentRestAPI.model;

public class Agent 
{   String id;
    int q;
    int r;
    int s;


    public Agent()
    {   id="1";
        q=0;
        r=0;
        s=0;
    }

    public Agent(String id,int q,int r,int s)
    {   this.id=id;
        this.q=q;
        this.r=r;
        this.s=s;
    }

    public String getID()
    {
        return id;
    }
    public int getQ()
    {
        return q;
    }

    public int getR()
    {
        return r;
    }

    public int getS()
    {
        return s;
    }
    
    public void setID(String id)
    {
        this.id=id;
    }
    public void setQ(int q)
    {
        this.q=q;
    }

    public void setR(int r)
    {
        this.r=r;
    }

    public void setS(int s)
    {
        this.s=s;
    }

}
