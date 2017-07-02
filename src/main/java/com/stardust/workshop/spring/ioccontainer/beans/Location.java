package com.stardust.workshop.spring.ioccontainer.beans;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("location")
//@Scope("prototype")
public class Location {
    private String province;
    private String city;
    private String address;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
