package com.heroBook.heroBook.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
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
        ArrayNode fnodeList = (ArrayNode) node.get("favouriteList");
        List l = new ArrayList<FavouriteHero>();
        if(fnodeList.isArray()) {
            for(JsonNode jsonNode : fnodeList) {
                l.add(new FavouriteHero(jsonNode.get("name").asText()));
            }
        }
        return new User(name, role, l);
    }
}