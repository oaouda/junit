package com.in38minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;
import org.mockito.internal.matchers.Any;

public class ListTest {

	@Test
	public void letsMockListSize_ReturnMultipleValues() {
		List listMock = mock(List.class);
		
		// The first time listMock.size is called it returns 2, the
		// second time, it returns 3
		when(listMock.size()).thenReturn(2).thenReturn(3);
		
		
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
					
	}

	
	@Test
	public void letsMockListGet() {
	
		// Given
		List listMock = mock(List.class);
		
		// The first time listMock.size is called it returns 2, the
		// second time, it returns 3
		// when(listMock.get(0)).thenReturn("in28minutes");
		given(listMock.get(0)).willReturn("in28minutes");
		
		// Argument Matcher, every time list get is called
		// anyInt, if called by any it
		// when(listMock.get(anyInt())).thenReturn("in28minutes");
		given(listMock.get(anyInt())).willReturn("in28minutes");
		
		
		// Then		
		assertEquals("in28minutes", listMock.get(0));
		assertEquals("in28minutes", listMock.get(1)); 		
	}
	
	
	@Test
	public void letsMockListGet_usingBDD() {
	
		// Given
		List <String>listMock = mock(List.class);			
		given(listMock.get(anyInt())).willReturn("in28minutes");

		// When
		String firstElement = listMock.get(0);
		
		// Then		
		assertThat(firstElement, is("in28minutes"));
		 		
	}
	
	
	
	@Test(expected=RuntimeException.class)
	public void letsMockListGet_throwException() {
		
		// Given list 
		List listMock = mock(List.class);
				
		// Argument Matcher, every time list get is called
		// anyInt, if called by any it
		
		// When
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Someting went wrong"));
		
		// Then
		assertEquals("in28minutes", listMock.get(0));
		assertEquals("in28minutes", listMock.get(1)); 
		listMock.get(0);
	}
	

}
