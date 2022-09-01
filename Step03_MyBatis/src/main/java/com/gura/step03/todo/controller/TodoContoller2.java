package com.gura.step03.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step03.todo.dto.TodoDto;
import com.gura.step03.todo.service.TodoService;

@Controller
public class TodoContoller2 {
	
	@Autowired
	private TodoService service;
	
	// Model, view page 정보를 동시에 담을 수 있는 ModelAndView 객체
	// TodoService 객체 이용, ModelAndView 객체에 동작한 정보 처리
	// 객체 mView에 view page의 정보도 담기
	// 이후 리턴.
	
	//CREATE-------------------------------------------
	@RequestMapping("/todo/insertform")

	public ModelAndView insertform(ModelAndView mView) {
		mView.setViewName("todo/insertform");
		return mView;
	}
	@RequestMapping("/todo/insert")
	public ModelAndView insert(TodoDto dto) {
		service.addTodo(dto);
		//모델은 담지 않고 view page 정보만 담아 리턴하는 경우
		return new ModelAndView("todo/insert");
	}
	//CREATE-------------------------------------------

	//READ-------------------------------------------
	@RequestMapping("/todo/list")
	public ModelAndView list() {
		ModelAndView mView=new ModelAndView();
		service.getListTodo(mView);
		mView.setViewName("todo/list");
		return mView;
	}	
	//READ-------------------------------------------

	
	//UPDATE-------------------------------------------
	@RequestMapping("/todo/updateform")
	public ModelAndView updateform(int num, ModelAndView mView) {
		service.getTodo(num, mView);
		mView.setViewName("todo/updateform");
		return mView;
	}
	@RequestMapping("/todo/update")
	public String update(TodoDto dto) {
		service.updateTodo(dto);
		return "todo/update";
	}
	//UPDATE-------------------------------------------

	//DELETE-------------------------------------------
	@RequestMapping("/todo/delete")
	public String delete(int num) {
		service.deleteTodo(num);
		return "redirect:/todo/list.do";
	}
	//DELETE-------------------------------------------

}
