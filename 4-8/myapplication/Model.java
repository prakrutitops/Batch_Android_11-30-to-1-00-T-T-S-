package com.example.myapplication;

public class Model
{
    String topicname;
    int image;


    public Model(String topicname,int image)
    {
        this.topicname=topicname;
        this.image=image;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }
}
