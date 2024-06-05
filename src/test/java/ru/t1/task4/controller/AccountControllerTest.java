package ru.t1.task4.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.t1.task4.model.Account;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(authorities = "SCOPE_ADMIN")
    public void testNewAccountAccessForAuthenticatedUser() throws Exception {
        Account account = new Account();
        account.setName("testUser");
        account.setPassword("password");
        account.setRoles("ROLE_USER");

        mockMvc.perform(MockMvcRequestBuilders.post("/account/new")
                        .contentType("application/json")
                        .content("{\"name\":\"testUser\",\"password\":\"password\",\"roles\":\"ROLE_USER\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testNewAccountAccessForUnauthenticatedUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/account/new")
                        .contentType("application/json")
                        .content("{\"name\":\"testUser\",\"password\":\"password\",\"roles\":\"ROLE_USER\"}"))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
}