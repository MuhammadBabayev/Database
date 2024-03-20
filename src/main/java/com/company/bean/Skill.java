package com.company.bean;

public class Skill {
    private int id;
    private String skill;

    public Skill(int id, String skill) {
        this.id = id;
        this.skill = skill;
    }
    
    public Skill(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "id=" + id + ", skill=" + skill;
    }
    
}
