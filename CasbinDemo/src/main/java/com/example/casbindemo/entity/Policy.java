package com.example.casbindemo.entity;

public class Policy {

    private Integer index;

    private String name;

    private String sub;

    private String obj;

    private String act;


    public Policy() {
    }

    public Policy(String sub, String obj, String act) {
        this.sub = sub;
        this.obj = obj;
        this.act = act;
    }

    public Policy(Integer index, String name, String sub, String obj, String act) {
        this.index = index;
        this.name = name;
        this.sub = sub;
        this.obj = obj;
        this.act = act;
    }

    public Policy(Integer index, String sub, String obj, String act) {
        this.index = index;
        this.sub = sub;
        this.obj = obj;
        this.act = act;
    }

    public Policy(String name, String sub, String obj, String act) {
        this.name = name;
        this.sub = sub;
        this.obj = obj;
        this.act = act;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }
}