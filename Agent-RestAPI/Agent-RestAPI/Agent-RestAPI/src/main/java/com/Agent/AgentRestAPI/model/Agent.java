package com.Agent.AgentRestAPI.model;

public class Agent 
{   String id;
    String q;
    String r;
    String s;


    public Agent()
    {   id="1";
        q="0";
        r="0";
        s="0";
    }

    public Agent(String id,String q,String r,String s)
    {   this.id=id;
        this.q=q;
        this.r=r;
        this.s=s;
    }

    public String getID()
    {
        return id;
    }
    public String getQ()
    {
        return q;
    }

    public String getR()
    {
        return r;
    }

    public String getS()
    {
        return s;
    }
    
    public void setID(String id)
    {
        this.id=id;
    }
    public void setQ(String q)
    {
        this.q=q;
    }

    public void setR(String r)
    {
        this.r=r;
    }

    public void setS(String s)
    {
        this.s=s;
    }

}
