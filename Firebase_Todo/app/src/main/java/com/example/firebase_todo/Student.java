package com.example.firebase_todo;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Student implements Serializable {
    @Exclude
    private String key;
    private String name;
    private String msv;
    public Student(){}
    public Student(String name, String msv)
    {
        this.name = name;
        this.msv = msv;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMsv()
    {
        return msv;
    }

    public void setMsv(String msv)
    {
        this.msv = msv;
    }
    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
