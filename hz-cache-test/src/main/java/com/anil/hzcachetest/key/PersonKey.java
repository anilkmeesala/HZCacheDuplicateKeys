package com.anil.hzcachetest.key;

import org.springframework.stereotype.Component;

/**
 * Created by anil on 1/10/2017.
 */
@Component
public class PersonKey {
    private String id;
    private String name;

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

	@Override
	public String toString() {
		return "PersonKey [id=" + id + ", name=" + name + "]";
	}
    
    
}
