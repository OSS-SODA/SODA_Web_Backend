package com.soda.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soda.web.dto.ClubMemberLoginDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthorizationTestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void login() throws Exception{
        ClubMemberLoginDTO member = new ClubMemberLoginDTO("testid","123");

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(writeItemToJsonString(member)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void accessWithAuthorization() throws Exception {
        MockHttpServletRequestBuilder req = get("/authorizationTest")
                .header("Authentication", "Bearer eyJhbGciOiJIUzI1NiJ9" +
                        ".eyJpc3MiOiJTT0RBIiwiaWF0IjoxNTk3NDIzMDc0LCJVU0VSX0lEIjoidGVzdGlkIiwiVVNFUl9ST0xFIjoiUk9MRV9VU0VSIn0" +
                        ".tf5nTwukZ6rAXTd9yHaS2BxLoekLJafyJIlLeotea9E")
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(status().isOk());
    }


    private String writeItemToJsonString(ClubMemberLoginDTO dto) throws JsonProcessingException {
        return objectMapper.writeValueAsString(dto);
    }
}