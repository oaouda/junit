package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParametrizedTest {

	StringHelper helper;
	
	private String input;
	private String expectedOutput;
	
	
	@Before
	public void setup() {
		helper = new StringHelper();
	}
	
	@Parameters
	public static Collection<String []> testConditions() {
		
		String expectedOutput [][] = {{"AACD", "CD"},{"ACD", "CD"}};
	
		return Arrays.asList(expectedOutput);
	}
	
	
	public StringHelperParametrizedTest(String input, String expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Test
	public void testTruncateAInFirst2Position_AinFirst2Positions() {
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}
	

	//ABCD => false;  ABAB -> true; AB - true; A-> false
	@Test
	public void testAreFirstAndLastTwoCharactersTheSameBasic() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
	@Test 
	public void testAreFirstAndLastTowCharactersTheSame() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
}
