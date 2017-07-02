package com.stardust.workshop.spring.ioccontainer.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("company")
@Scope("singleton")
public class Company {
    private String string = "Great Company";
    //@Autowired
  //  @Qualifier("person")
    private Person owner;

//    @Autowired
    //@Qualifier("location")
    private Location location;

    public Company() {
        System.out.println("Constructing Bean: Company");
    }

    @PostConstruct
    public void init() {
        System.out.println("After construct Bean: Company");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Before destroy Bean: Company");
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
