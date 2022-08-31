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
	//어떻게 자동으로 해준거지?
	
	/*
	 * @ 어노테이션을 많이 사용할 예정인데,
	 * 어노테이션에 대한 이해가 필요해.
	 * 스프링 프레임워크는 골뱅이 천지다. 이놈으로 왠만한 건 다 해.
	 * 우리가 알고 있는 상식은 상속이나 인터페이스로 하는건데, 골뱅이는 대체 뭐지?
	 * 
	 * -어노테이션 : 어노테이션이 붙은 클래스는 그 모양 그대로 사용되지 않고
	 *  런타임시에 변형되어서 사용된다.
	 *  어떤 변형? 특정 클래스를 상속받기도 하고, 특정 인터페이스를 구형하기도 하고
	 *  없던 메소드가 만들어지기도 하고, 없던 필드가 추가되기도 하는 등등의 자동화 작업...
	 * 
	 */
}
