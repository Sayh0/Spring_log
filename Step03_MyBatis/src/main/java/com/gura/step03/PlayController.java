package com.gura.step03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayController {
	
//	@RequestMapping("/play")
//	public ModelAndView play(ModelAndView mView) { // 모델엔뷰를 생성하지 않고 메소드 인자로 받을 수도 있다.
//		mView.setViewName("play"); // /WEB-INF/views/play.jsp 의 단축
//
	
 /* aspect 로  바꾸기 */
	
	//로그인된 클라이언트의 요청만 정상수행하는 메소드
	@RequestMapping("/play")
	public ModelAndView authPlay(ModelAndView mView, HttpServletRequest request) {
      
		mView.setViewName("play");
	
		return mView;
	}
	@RequestMapping("/sub/play2")
	public ModelAndView authPlay2(ModelAndView mView, HttpServletRequest request) {
		mView.setViewName("sub/play2");
		return mView;
	}
	
}
