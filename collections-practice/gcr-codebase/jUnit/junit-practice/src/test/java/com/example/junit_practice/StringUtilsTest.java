package com.example.junit_practice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringUtilsTest {
	StringUtils utils = new StringUtils();
	
	@Test
	void testReverse() {
		assertEquals("olleh", utils.reverse("hello"));
	}
	
	@Test
	void testIsPalindrome() {
		assertTrue(utils.isPalindrome("madam"));
		assertFalse(utils.isPalindrome("hello"));
	}
	
	@Test
	void testToUpperCase() {
		assertEquals("JAVA", utils.toUpperCase("java"));
	}
}
