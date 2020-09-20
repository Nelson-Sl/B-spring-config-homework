package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = {"levelNumber: 1"})
@AutoConfigureMockMvc
class DemoSpringConfigApplicationEqualTests {
	@Autowired
	private MockMvc mockMvc;

	@Value("${levelNumber}")
	private int levelNumber;

	@Test
	void shouldGetLevelNumberOfThree() {
		Assertions.assertEquals(1, levelNumber);
	}

	@Test
	void shouldBeAdvancedWhenLevelNumEqualsOne() throws Exception {
		String result = mockMvc.perform(get("/level"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		Assertions.assertEquals("advanced", result);
	}

}
