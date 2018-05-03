package com.utn.francolisotti.TP4.model;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String browser;
    private String operativeS;

    public User() {
    }

    public User (String browser, String operativeS){
        this.browser=browser;
        this.operativeS=operativeS;
    }

    public String getBrowser(){
        return this.browser;
    }

    public String getOperativeS(){return this.operativeS; }
}
