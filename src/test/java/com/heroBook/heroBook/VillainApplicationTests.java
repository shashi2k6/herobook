package com.heroBook.heroBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroBook.heroBook.model.Hero;
import com.heroBook.heroBook.model.Villain;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@SpringBootTest
public class VillainApplicationTests {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    void initVillain() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/villain")
                .content(objectMapper.writeValueAsString(createVillianObject()))
                .contentType(MediaType.APPLICATION_JSON));
    }

    /**
     * Test to check if villain is empty.
     * @throws Exception
     */
    @Test
    void testToGetEmptyVillain() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/villain"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*",hasSize(0)));
    }

    /**
     * Test to add a Villain.
     * @throws Exception
     */
    @Test
    void testAddVillain() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/villain")
                .content(objectMapper.writeValueAsString(createVillianObject()))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    /**
     * Test to get all the villains.
     * @throws Exception
     */
    @Test
    void testToGetAllVillains() throws Exception {
        initVillain();
        mockMvc.perform(MockMvcRequestBuilders.get("/api/villain"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(1)));
    }

    /**
     * To clean up all the datasource
     */
    @AfterEach
    void tearDown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/cleanupvillian")).andExpect(status().isOk());
    }


    /**
     * Create the Villian Object
     * @return
     */
    private Villain createVillianObject(){
        return new Villain("archRival","ImageName","Villan","Spiderman","6 feet 30 inches","70 kg",
                "Webs & Strings","Fast thinker","Webs & Flexible",
                "200 km/hour","Very fast","Spiderman - Super Hero saves the world",
                "SuperHero saves the city from all the villians");
    }
}
