package com.hhaouari.roverscan;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class RoverscanApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	void testWorkingTests() {
		Assert.isTrue(true, "Tests Are Working ok.");
	}

}
