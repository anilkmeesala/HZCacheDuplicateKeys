package com.anil.hzcachetest.key;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

@Component
public class PersonKeySerializer implements StreamSerializer<PersonKey>{

	public void destroy() {
		
	}

	public int getTypeId() {
		return 1;
	}

	public PersonKey read(ObjectDataInput in) throws IOException {
		PersonKey pk =new PersonKey();
		pk.setId(in.readUTF());
		pk.setName(in.readUTF());
		return pk;
	}

	public void write(ObjectDataOutput out, PersonKey object) throws IOException {
		out.writeUTF(object.getId());
		out.writeUTF(object.getName());
		
	}

}
