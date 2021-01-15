package com.heroBook.heroBook;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroBook.heroBook.model.FavouriteHero;
import com.heroBook.heroBook.model.Hero;
import com.heroBook.heroBook.model.User;
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
@Transactional
public class UserRoleApplicationTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void test_emptyFavouriteList() throws Exception{
        initUser(createUserObject());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/userfavourlist").param("username","Fan"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.favouriteList").isEmpty());

    }

    /**
     * Test to get all the heroes.
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
     * To create the dummy hero object for the testing purpose.
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
        User user = new User("","");
        user.setName("Fan");
        user.setRole("A registered user who can create Favorites lists of heroes.");
        return user;
    }

    private User addFavourite(User user) throws JsonProcessingException {

        List<FavouriteHero> favList = new ArrayList<FavouriteHero>();
        favList.add(new FavouriteHero("Spidername"));
        user.setFavouriteList(favList);

        System.out.println(objectMapper.writeValueAsString(user));

        return user;
    }
}
