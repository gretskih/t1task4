package ru.t1.task4.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(authorities = "SCOPE_USER")
    public void testAuthenticatedUserAccess() throws Exception {
        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUnauthenticatedUserAccess() throws Exception {
        mockMvc.perform(get("/students/1"))
                .andExpect(status().isUnauthorized());
    }
}