package com.gura.step01;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
		
	// /home.do 요청이 왔을 때 동작하는 컨트롤러 메소드
	@RequestMapping("/home.do")
	public String home(HttpServletRequest request) {
		
		//DB 에서 읽어온 공지사항 이라고 가정하자.
		List<String> noticeList=new ArrayList<>();
		noticeList.add("String Framework 시작입니다.");
		noticeList.add("화이팅!");
		noticeList.add("어쩌구...");
		noticeList.add("저쩌구...");
		
		//view page(=jsp page)에 전달한 Model(=data)를 request 영역에 담기.
		request.setAttribute("noticeList", noticeList);
		//어떤 key값으로 어떤 type을 담았는지 반드시 기억해야 함. 숫자인지 문자인지 list인지 map 인지
		
		// /WEB-INF/views/home.jsp 페이지로 forward 이동해서 응답
		return "home";
	}
	//어떤 요청에 대해서 동작할 요청 경로를 명시(.do 는 생략 가능)
	//메소드의 리턴타입은 주로 String 또는 ModelView 이다.
	//메소드 명은 마음대로 지을 수 없다.
	//메소드에 필요한 인자는 필요시에 선언하면 해당 객체의 참조값이 알아서 전달된다.
	//전달되는 type : HttpServletRequest, HttpServletResponse, HttpSession, ModelAndView 등등
	//String type을 리턴하는 경우 forward 이동할 경로 혹은 redirect 이동할 경로를
	//문자열로 구성해서 리턴하면 된다.
	@RequestMapping("/study.do") //반드시 /(슬래시)로 시작해야 함
	public String study() {
		
		// /WEB-INF/views/study.jsp 페이지로 forward 이동해서 응답
		return "study"; // 이건 /(슬래시)로 시작하면 안됨!
	}
	
	@RequestMapping("/sub/play") 
	public String play() {
		return "sub/play"; 
	}
}

