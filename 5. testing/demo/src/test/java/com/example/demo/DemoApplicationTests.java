package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.classes.Example;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		boolean a = true;

		if(a){
			assertEquals(true, true);
		}else{
			assertFalse(a);
		}
	}

	@Test
	void test() {
		Example example = new Example();
		assertFalse(6 == example.getTriple(5));
	}

	@Test
	void getDouble_returns_equals() {
		Example example = new Example();
		assertEquals(4, example.getDouble(2));
	}

}
