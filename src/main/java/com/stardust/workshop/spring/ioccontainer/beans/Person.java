package com.stardust.workshop.spring.ioccontainer.beans;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("person")
//@Scope("prototype")
public class Person {
    private Long SID;
    private String name;

    public Long getSID() {
        return SID;
    }

    public void setSID(Long SID) {
        this.SID = SID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
