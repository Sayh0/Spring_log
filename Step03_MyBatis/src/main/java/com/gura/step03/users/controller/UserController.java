package com.gura.step03.users.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	//로그인 요청 처리 할 컨트롤러 메소드 
	@RequestMapping("/users/login")
	public ModelAndView login(String id, HttpSession session) {
		//입력할 아이디와 비밀번호가 유효한 정보이면 로그인 처리를 한다.
		session.setAttribute("id", id); // 입력할 아이디를 저장할 session 영역
		return new ModelAndView("users/login");
	}
	
	// 로그아웃 처리를 할 컨트롤러 메소드
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		// session 영역에 id라는 키값으로 저장된 값 삭제.
		session.removeAttribute("id"); // 로그아웃 처리
		return "redirect:/home.do"; // 인덱스 페이지로 리다이렉트 시ㅋ기.
	}
	
	// 로그인 폼 요청 처리를 할 컨트롤러 메소드
	@RequestMapping("/users/loginform")
	public String loginform() {
		
		return "users/loginform"; //위에처럼 모델엔뷰를 리턴해도 되고 지금처럼 스트링으로도 가능.
	}
}
