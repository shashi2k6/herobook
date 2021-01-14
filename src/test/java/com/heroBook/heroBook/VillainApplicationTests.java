package com.heroBook.heroBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

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
                .content(objectMapper.writeValueAsString(new Villain("Joker")))
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
                .content(objectMapper.writeValueAsString(new Hero("Joker")))
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


}
