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

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;


//-- @RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMockTest {	
	// TodoService todoServiceMock = mock(TodoService.class);	
	
	// Add the @Rule, then remove the @RunWith(MockitoJUnitRunner.class)
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	
	
	@Mock
	TodoService todoServiceMock;
	
	// TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

	
	// ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	@Test
	public void testRetrieveTodosRelatedToSpring() {
		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy"))
			.thenReturn(todos);		
					
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpringWithEmptyList() {
				
		List<String> todos = Arrays.asList();
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);		
					
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDDMock() {
		
		// Given
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");			
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);		
		// when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		// When
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		
		// Then
		// assertEquals(2, filteredTodos.size());
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void testDeleteTodosRelatedToSpring_usingBDD() {
		
		// Given
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");			
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		// When
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
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");			
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");			
		
		// Then
		//-- verify(todoServiceMock).deleteTodo("Learn to Dance");		
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
				
	}
	
	@Test
	public void testDeleteTodosRelatedToSpring_usingBDD_argumentCaptureMultipleTimes() {
		
		// Declare an argument capture
		// Define argument capture on specific method call
		// Capture the argument
					
		// Given
		List<String> todos = Arrays.asList("Learn to Rock and Roll", "Learn Spring", "Learn to Dance");			
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");			
		
		// Then
		//-- verify(todoServiceMock).deleteTodo("Learn to Dance");		
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
				
	}

}
