package com.gura.step02.member;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping(value="/member/insertform.do")
	public String insertform(HttpServletRequest request) {
		
		// /WEB-INF/views/member/insertform.jsp 페이지에서 응답하기
		return "member/insertform";
	}
	@RequestMapping("/member/insert")
	public String insert(HttpServletRequest request) {
		int num=Integer.parseInt(request.getParameter("num"));
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		
		System.out.println(num + " | " + name + " | " + addr);
		
		return "member/insert";
	}
	//컨트롤러 메소드의 매개변수를 이용해서 파라미터 추출하기
	@RequestMapping("/member/insert2")
	public String insert2(int num, String name, String addr) {
		//파라미터 int로 선언하면 알아서 숫자로 넣어줌. parseInt 안 써도 된다 얏호!
		
		System.out.println(num + " | " + name + " | " + addr);

		return "member/insert";
	}
	//컨트롤러 메소드의 매개변수에 dto를 선언해도 된다.
	//단 자동으로 들어가는 조건은 dto의 필드명과 form 전송되는 parameter 명이 일치해야 함
	//왠만하면 똑같이 쓰자구 그러니까.
	@RequestMapping("/member/insert3")
	public String insert3(MemberDto dto) {
		
		System.out.println(dto.getNum() + " | " + dto.getName() + " | " + dto.getAddr());
		
		return "member/insert";
	}

}
