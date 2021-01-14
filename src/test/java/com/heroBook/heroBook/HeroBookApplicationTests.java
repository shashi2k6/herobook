package com.heroBook.heroBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroBook.heroBook.model.Hero;
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
public class HeroBookApplicationTests {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    /**
     * To create the dummy hero object for the testing purpose.
     * @throws Exception
     */
    void initHero() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/hero")
                .content(objectMapper.writeValueAsString(createHeroObject()))
                .contentType(MediaType.APPLICATION_JSON));
    }

    /**
     * Test to check if hero is empty.
     * @throws Exception
     */
    @Test
    void testToGetEmptyHero() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hero"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*",hasSize(0)));
    }

    /**
     * Test to add a Hero.
     * @throws Exception
     */
    @Test
    void testAddHero() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/hero")
                .content(objectMapper.writeValueAsString(createHeroObject()))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    /**
     * Test to get all the heroes.
     * @throws Exception
     */
    @Test
    void testToGetAllHeroes() throws Exception {
        initHero();
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hero"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(1)));

    }

    /**
     * Test to get Hero by Name.
     * @throws Exception
     */
    @Test
    public void testToGetHeroByName() throws Exception {
        initHero();
        mockMvc.perform(MockMvcRequestBuilders.get("/api/heroByName").param("heroName", "Andrew Garfield"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.image").value("ImageName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.heroName").value("Andrew Garfield"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.height").value("6 feet 30 inches"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.weight").value("70 kg"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.specialPower").value("Webs & Strings"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.intelligence").value("Fast thinker"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.strength").value("Webs & Flexible"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.speed").value("200 km/hour"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.agility").value("Very fast"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Spiderman - Super Hero saves the world"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.story").value("SuperHero saves the city from all the villians"));
    }


    /**
     * Test to to check user not found in the repository
     * @throws Exception
     */
    @Test
    public void testHeroNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/heroByName").param("heroName", "Spiderman"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("Hero doesn't exist"));
    }


    /**
     * To clean up all the datasource
     */
    @AfterEach
    void tearDown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/cleanuphero")).andExpect(status().isOk());
    }

    /**
     * Create the Hero Object
     * @return
     */
    private Hero createHeroObject(){
        return new Hero("ImageName","SpiderMan","Andrew Garfield","6 feet 30 inches","70 kg",
                "Webs & Strings","Fast thinker","Webs & Flexible",
                "200 km/hour","Very fast","Spiderman - Super Hero saves the world",
                "SuperHero saves the city from all the villians");
    }
}
