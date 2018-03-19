package com.in38minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;
import com.in38minutes.data.api.TodoServiceStub;

public class TodoBusinessImplMockTest {

	
	
	// What is mocking
	@Test
	public void testRetrieveTodosRelatedToSpring() {
		
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy"))
			.thenReturn(todos);		
					
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpringWithEmptyList() {
		
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList();
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);		
					
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDDMock() {
		
		// Given
		TodoService todoServiceMock = mock(TodoService.class);		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");			
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);		
		// when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		// When
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		
		// Then
		// assertEquals(2, filteredTodos.size());
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void testDeleteTodosRelatedToSpring_usingBDD() {
		
		// Given
		TodoService todoServiceMock = mock(TodoService.class);		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");			
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		// When
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");			
		
		// Then
		//-- verify(todoServiceMock).deleteTodo("Learn to Dance");		
		then(todoServiceMock).should().deleteTodo("Learn to Dance");
		
		//- verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
		
		verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
		verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to Dance");	
	}
	
	@Test
	public void testDeleteTodosRelatedToSpring_usingBDD_argumentCapture() {
		
		// Declare an argument capture
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		// Define argument capture on specific method call
		// Capture the argument
		
		
		
		// Given
		TodoService todoServiceMock = mock(TodoService.class);		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");			
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		// When
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");			
		
		// Then
		//-- verify(todoServiceMock).deleteTodo("Learn to Dance");		
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
				
	}
	
	@Test
	public void testDeleteTodosRelatedToSpring_usingBDD_argumentCaptureMultipleTimes() {
		
		// Declare an argument capture
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		// Define argument capture on specific method call
		// Capture the argument
					
		// Given
		TodoService todoServiceMock = mock(TodoService.class);		
		List<String> todos = Arrays.asList("Learn to Rock and Roll", "Learn Spring", "Learn to Dance");			
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		// When
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");			
		
		// Then
		//-- verify(todoServiceMock).deleteTodo("Learn to Dance");		
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
				
	}

}
