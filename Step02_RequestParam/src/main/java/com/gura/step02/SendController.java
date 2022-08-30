package com.gura.step02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Controller 생성을 위해 어노테이션을 import.
@Controller
public class SendController {
	
	@RequestMapping("/add.do")
	public String add() {
		
		return "result";
	}
	
	/* 잘못된 코드 */
//	@RequestMapping("/add.do")
//	public String add2() {
//		
//		return "result";
//	}
	/* 같은 경로로 Mapping 요청을 하게 되면 500 에러 뱉으면서 서버가 튕김 */	
	
	//method 방식을 다르게 하고 경로를 같게 하려면 이런 식으로 하면 된다.
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add2(String content) {
		System.out.println("get 방식 요청 : "+content);
		return "result";
	}
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String add3(String content) {
		System.out.println("post 방식 요청 : "+content);
		return "result";
	}
	
	
	
	/*
	 * 요청 파라미터를 추출하는 방법 1.
	 * 
	 * 메소드의 인자로 HttpServletRequest 객체를 전달받은 다음
	 * 해당 객체의 getParameter() 메소드를 이용해 추출한다.
	 * (서블릿이나 jsp에서 하던 방식)
	 * 
	 */
	@RequestMapping("/send")
	public String send(HttpServletRequest request) {
		//msg 라는 파라미터 명으로 전송되는 문자열 추출하기
		String msg=request.getParameter("msg");
		//콘솔창에 출력하기
		System.out.println("msg : "+msg);
		//응답하기
		return "result";
	}
	
	/*
	 * 요청 파라미터를 추출하는 방법 2.
	 * 
	 * 파라미터 명과 동일한 이름의 매개변수를 선언하면 자동으로 추출되어서 전달된다.
	 * 
	 * <input name="msg"> => String msg
	 * <input name="num"> => int num or String num
	 * XXX./do?msg=xxx	  => String msg
	 * XXX./do?num=xxx	  => int num or String num
	 * (easy~)
	 */
	@RequestMapping("/send2")
	public String send2(String msg) {
		System.out.println("msg : "+msg);
		return "result";
	}
}
