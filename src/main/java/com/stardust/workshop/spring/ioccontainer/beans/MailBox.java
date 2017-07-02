package com.stardust.workshop.spring.ioccontainer.beans;


import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.soap.Addressing;

public class MailBox {

    private String boxCode;

    private Person owner;

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
