package com.in38minutes.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;
import com.in38minutes.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

}
