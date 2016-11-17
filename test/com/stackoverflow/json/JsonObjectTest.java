package com.stackoverflow.json;

import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonObjectTest {

    private static String JSON_OBJ = "{\"name\":\"Jonas Dämfors\",\"email\":\"jonas@handlar.nu\",\"age\":38}";

    @Test
    public void testJsonObject() throws Exception {
        JsonObject obj = new JsonObject("Jonas Dämfors", "jonas@handlar.nu", 38);
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        assertEquals(JSON_OBJ, json);
    }

    @Test
    public void testStringToJsonObject() throws Exception {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(JSON_OBJ, JsonObject.class);
        assertEquals("Jonas Dämfors", jsonObject.getName());
        assertEquals("jonas@handlar.nu", jsonObject.getEmail());
        assertEquals(38, jsonObject.getAge());
    }


}