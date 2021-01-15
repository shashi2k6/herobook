package com.heroBook.heroBook;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.heroBook.heroBook.model.User;

import java.io.IOException;

public class UserSerializer extends StdSerializer<User> {
    
    public UserSerializer() {
        this(null);
    }
  
    public UserSerializer(Class<User> t) {
        super(t);
    }

    @Override
    public void serialize(User user, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", user.getId());
        jgen.writeStringField("name", user.getName());
        jgen.writeStringField("role", user.getRole());
        jgen.writeEndObject();
    }
/*
    @Override
    public void serialize(
            User value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
 
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.id);
        jgen.writeStringField("itemName", value.itemName);
        jgen.writeNumberField("owner", value.owner.id);
        jgen.writeEndObject();
    }*/

    public static void main(String[] args) {

    }
}