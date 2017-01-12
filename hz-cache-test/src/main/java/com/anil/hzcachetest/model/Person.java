package com.anil.hzcachetest.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * Created by anil on 1/10/2017.
 */
@Component
public class Person implements Serializable {
    private String id;
    private String name;
    private String city;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + "]";
	}

 
}
