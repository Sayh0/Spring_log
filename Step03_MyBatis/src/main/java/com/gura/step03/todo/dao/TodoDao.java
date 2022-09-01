package com.gura.step03.todo.dao;

import com.gura.step03.todo.dto.TodoDto;

import java.util.List;

//Interface를 활용한 틀 만들기.
public interface TodoDao {
	public List<TodoDto> getList();
	public TodoDto getData(int num);
	public void insert(TodoDto dto);
	public void update(TodoDto dto);
	public void delete(int num);
	
}
