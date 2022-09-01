package com.gura.step03.todo.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.step03.todo.dto.TodoDto;

public interface TodoService {
	//CREATE todo info method
	public void addTodo(TodoDto dto);
	//READ todo info method
	public void getTodo(int num, ModelAndView mView);
	public void getListTodo(ModelAndView mView);
	//UPDATE todo info method
	public void updateTodo(TodoDto dto);
	//DELETE todo info method
	public void deleteTodo(int num);
}
