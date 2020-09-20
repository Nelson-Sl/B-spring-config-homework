package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("anotherTest")
public class DemoSpringConfigApplicationAnotherTests {
    @Autowired
    private MockMvc mockMvc;

    @Value("${levelNumber}")
    private int levelNumber;

    @Test
    void shouldGetAnotherTestPropertiesAsNegativeOne() {
        Assertions.assertEquals(-1, levelNumber);
    }

    @Test
    void shouldBeBasicWhenLevelNumLessThanOne() throws Exception {
        String result = mockMvc.perform(get("/level"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals("basic", result);
    }
}
