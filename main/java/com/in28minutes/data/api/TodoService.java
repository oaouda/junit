package com.in28minutes.data.api;

import java.util.List;

// Create TodoServiceStud
// Test todoBusinessImpl using TodServiceStud
public interface TodoService {
	public List<String> retrieveTodos(String user);
	public void deleteTodo(String todo);
}
