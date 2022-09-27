package com.Agent.AgentRestAPI;

public class Agent 
{
    String q;
    String r;
    String s;


    Agent()
    {
        q="0";
        r="0";
        s="0";
    }

    Agent(String q,String r,String s)
    {
        this.q=q;
        this.r=r;
        this.s=s;
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
