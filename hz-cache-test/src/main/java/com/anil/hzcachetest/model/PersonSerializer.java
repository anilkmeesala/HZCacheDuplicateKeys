package com.anil.hzcachetest.model;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

public class PersonSerializer implements StreamSerializer<Person>{

	@Override
	public void destroy() {
		
	}

	@Override
	public int getTypeId() {
		return 11;
	}

	@Override
	public Person read(ObjectDataInput in) throws IOException {
		Person p = new Person();
		p.setId(in.readUTF());
		p.setName(in.readUTF());
		p.setCity(in.readUTF());
		p.setState(in.readUTF());
		return p;
	}

	@Override
	public void write(ObjectDataOutput out, Person object) throws IOException {
		out.writeUTF(object.getId());
		out.writeUTF(object.getName());
		out.writeUTF(object.getCity());
		out.writeUTF(object.getState());
	}

}
