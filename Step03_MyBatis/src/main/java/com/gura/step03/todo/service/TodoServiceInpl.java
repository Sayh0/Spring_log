package com.gura.step03.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step03.todo.dao.TodoDao;
import com.gura.step03.todo.dto.TodoDto;

@Service
public class TodoServiceInpl implements TodoService{
	
	//의존객체 주입받기
	@Autowired
	private TodoDao dao;
	
	//CREATE
	@Override
	public void addTodo(TodoDto dto) {
		dao.insert(dto);
	}
	
	//READ
	@Override
	public void getTodo(int num, ModelAndView mView) {
		TodoDto dto=dao.getData(num);
		mView.addObject("dto", dto);
	}
	@Override
	public void getListTodo(ModelAndView mView) {
		List<TodoDto> list=dao.getList();
		mView.addObject("list", list);
	}

	//UPDATE
	@Override
	public void updateTodo(TodoDto dto) {
		dao.update(dto);
	}
	
	//DELETE
	@Override
	public void deleteTodo(int num) {
		dao.delete(num);
	}

}
