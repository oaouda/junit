package com.in28minutes.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		List arrayListSpy = spy(ArrayList.class);  // like new ArrayList
		assertEquals(0, arrayListMock.size());
		arrayListSpy.add("Dummy");
		assertEquals(1, arrayListSpy.size());
		
		
	}

}
