package com.heroBook.heroBook.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.heroBook.heroBook.model.FavouriteHero;
import com.heroBook.heroBook.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDeserializer extends StdDeserializer<User> {

    public UserDeserializer() {
        this(null);
    }

    public UserDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public User deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        int id = (Integer) ((IntNode) node.get("id")).numberValue();
        String name = node.get("name").asText();
        String role = node.get("role").asText();
        JsonNode fnode = node.findValue("favouriteList");
        List l = new ArrayList<FavouriteHero>();
        JsonNode fdnode = fnode.get(0);
        if (null != fdnode) {
            l.add(new FavouriteHero(fdnode.get("name").asText()));
        }
        return new User(name, role, l);
    }
}