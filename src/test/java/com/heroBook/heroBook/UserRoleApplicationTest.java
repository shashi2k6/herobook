package com.heroBook.heroBook;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroBook.heroBook.model.FavouriteHero;
import com.heroBook.heroBook.model.Hero;
import com.heroBook.heroBook.model.User;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@SpringBootTest
public class UserRoleApplicationTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Test to check the list empty or not.
     * @throws Exception
     */
    @Test
    void test_emptyFavouriteList() throws Exception{
        initUser(createUserObject());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/userfavourlist").param("username","Fan"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.favouriteList").isEmpty());

    }

    /**
     * Test to get all the favourite list.
     * @throws Exception
     */
    @Test
    void test_getFavouriteList() throws Exception {
        initUser(addFavourite(createUserObject()));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/userfavourlist").param("username","Fan"))
                //.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.favouriteList.[*]",hasSize(1)));

    }

    /**
     * Test to remove my favourite hero from list.
     * @throws Exception
     */
    //@Test
    void test_removeFavouriteList() throws Exception {
        initUser(addFavourite(createUserObject()));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/removefavourite").param("name","Batman"))
                //.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.favouriteList.[*]",hasSize(1)));

    }


    /**
     * To clean up all the datasource
     */
    @AfterEach
    void tearDown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/cleanupuser")).andExpect(status().isOk());
    }

    /**
     * To create the dummy user object for the testing purpose.
     * @throws Exception
     */
    void initUser(User user) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/addfavourite")
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }

    /**
     * Create the User Object
     * @return
     */
    private User createUserObject(){
        return new User("Fan","A registered user who can create Favorites lists of heroes.");
    }

    /**
     * Add the Favourite list to the user
     * @param user
     * @return
     * @throws JsonProcessingException
     */
    private User addFavourite(User user) throws JsonProcessingException {
        List<FavouriteHero> favList = new ArrayList<FavouriteHero>();
        favList.add(new FavouriteHero("Spidername"));
        //favList.add(new FavouriteHero("Batman"));
        user.setFavouriteList(favList);
        return user;
    }
}
