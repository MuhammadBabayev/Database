package com.company.bean;

import java.sql.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String profile_description;
    private Date birthdate;
    private String adress;
    private String country;
    private String nationality;
    private List<UserSkill> skill;
  
    public User(){
        
    }
    public User(int id){
        this.id=id;
    }

    public User(int id, String name, String surname, String phone, String email,String profile_description,Date birthdate,String adress,  String country,String nationality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.profile_description=profile_description;
        this.birthdate=birthdate;
        this.adress=adress;
        this.country=country;
        this.nationality=nationality;
    }

    public String getProfile_description() {
        return profile_description;
    }

    public void setProfile_description(String profile_description) {
        this.profile_description = profile_description;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserSkill> getSkill() {
        return skill;
    }

    public void setSkill(List<UserSkill> skill) {
        this.skill = skill;
    }
    
    

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", email=" + email + ", profile_description=" + profile_description + ", birthdate=" + birthdate + ", adress=" + adress + ", country=" + country + ", nationality=" + nationality;
    }
}