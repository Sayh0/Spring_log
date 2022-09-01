package com.gura.step03.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gura.step03.todo.dao.TodoDao;
import com.gura.step03.todo.dto.TodoDto;

//@Controller 2 기능 위해 기존 콘트롤러 동작중지.
public class TodoContoller {
	
	@Autowired
	private TodoDao dao;
	
	//LIST
	@RequestMapping("/todo/list")
	public String list(HttpServletRequest request) {
		List<TodoDto> list=dao.getList();
		request.setAttribute("list", list);
		return "todo/list";
	}	
	
	   //추가완료
	   @RequestMapping("/todo/insert")
	   public String insert(TodoDto dto) {
		   //todoDao 객체를 이용해서 추가하기
		   dao.insert(dto);
		   //view page 로 forward 이동해서 응답하기
		   return "todo/insert";
	   }
	   //추가
	   @RequestMapping("/todo/insertform")
	   public String insertform() {
		   return "todo/insertform";
	   }
	   
	   //DELETE
	   @RequestMapping("/todo/deleteform")
	   public String deleteform(HttpServletRequest request) {
	      List<TodoDto> list=dao.getList();
	      request.setAttribute("list", list);
		   return "todo/deleteform";
	   }
	   
	   @RequestMapping("/todo/delete")
	   public String delete(int num) {
			//todoDto로 삭제
			dao.delete(num);
			return "todo/delete";
	   }
	   
	   //UPDATE
	   @RequestMapping("/todo/updateform")
	   public String updateform(int num, HttpServletRequest request) {
			TodoDto dto=dao.getData(num);
			//view page에 전달할 모델(data)를 request 영역에 담는다.
			request.setAttribute("dto", dto);
			   
			List<TodoDto> list=dao.getList();
			request.setAttribute("list", list);
	   
			return "todo/updateform";
	   }
	   @RequestMapping("/todo/update")
	   public String update(TodoDto dto) {
			dao.update(dto);
			return "todo/update";
	   }
}
