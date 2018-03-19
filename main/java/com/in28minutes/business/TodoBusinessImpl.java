package com.in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.data.api.TodoService;

// SUT system under test
// TodoService Dependency

public class TodoBusinessImpl{
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	public List<String>retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodo = new ArrayList<String>();
		List<String> todos = todoService.retrieveTodos(user);
		
		for (String todo:todos) {
			if (todo.contains("Spring")) {
				filteredTodo.add(todo);
			}
		}
		
		return filteredTodo;					
	}
	
	public void deleteTodosNotRelatedToSpring(String user) {
		List<String> filteredTodo = new ArrayList<String>();
		List<String> todos = todoService.retrieveTodos(user);
		
		for (String todo:todos) {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}		
	}

}
