package com.retail.rewards.web.controller;

import com.retail.rewards.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@ContextConfiguration(classes = Application.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RewardsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetRewards() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rewards")
                        .param("startDate", "2023-01-01")
                        .param("endDate", "2024-02-13")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(15))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].customerId").value("alphonseferrell"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].total").value(225));
    }

    @Test
    void testGetRewardsByCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rewards/alphonseferrell")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value("alphonseferrell"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(225));
    }

}
