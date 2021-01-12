package com.heroBook.heroBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@SpringBootTest
public class HeroBookApplicationTests {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;


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
     * Test to get all the heroes.
     * @throws Exception
     */
    @Test
    void testToGetAllHeroes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hero"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(1)));

    }

    /**
     * Test to add the hero.
     * @throws Exception
     */
    @Test
    void testAddHero() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/hero")
                .content(objectMapper.writeValueAsString(new Hero("Spiderman")))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    public void testToGetHeroByName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/heroByName").param("heroName", "Spiderman"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].heroName").value("Spiderman"));
    }

}
