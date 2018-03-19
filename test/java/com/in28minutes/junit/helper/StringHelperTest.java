package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {

	StringHelper helper;
	
	@Before
	public void setup() {
		helper = new StringHelper();
	}
	
	@Test
	public void testTruncateAInFirst2Position_AinFirst2Positions() {
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}

	//ABCD => false;  ABAB -> true; AB - true; A-> false
	@Test
	public void testAreFirstAndLastTwoCharactersTheSameBasic() {
		//assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
	@Test 
	public void testAreFirstAndLastTowCharactersTheSame() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
}
