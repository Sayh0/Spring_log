package com.gura.test1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// @Controller는 이 객체로 클라이언트의 요청에 대해 응답하겠다는 의미이다.
@Controller
public class HomeController {
	
// @RequestMapping은 해당하는 context에 root 요청이 왔을 때 해당 메소드로 응답한다는 의미이다.
	
	/*
	 *  HttpServletRequest, HttpServletResponse, HttpSession 등의 객체가
	 *  메소드 안에서 필요하다면, 필요한 객체를 전달받을 매개변수를 선언해 놓음으로서
	 *  자동으로 객체가 전달된다.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// return이 home 인것 보니 아무래도 생성자 느낌인 듯 하다.
		// serverTime 요청에 대한 응답도 있군.
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		int sum = 3+5;
		model.addAttribute("serverTime", formattedDate );
		
		model.addAttribute("calculator", sum);
		
		return "home";
	}
	   // "/test" 경로의 요청이 왔을 때 이 메소드를 이용해서 응답을 하겠다는 의미.
	   @RequestMapping("/test")
	   public String study() {
		   // /WEB-INF/views/test.jsp 페이지로 forward 이동해서 응답하겠다는 의미.
		   return "test";
	   }
	
	
}
