
package com.gura.step03.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step03.member.dao.MemberDao;
import com.gura.step03.member.dto.MemberDto;

/*
 *  컨트롤러에 대한 이해
 *  
 *  - 컨트롤러에서는 DAO를 이용한 복잡한 비즈니스 로직 처리는 하지 않는 것이 원칙이다.
 *    따라서 컨트롤러에서 DAO에 의존하고 있는 것은 바람직한 구조가 아니다.
 *    그럼 DAO를 활용한 비즈니스 로직 처리는 어떻게 해야 하는 걸까?
 *    답) 서비스 객체를 이용해서 로직 처리를 해야 한다!
 *    
 *  - 따라서 컨트롤러는 DAO에 의존하지 않고, 대신 서비스 객체에 의존하도록 설계한다.
 *    그럼 컨트롤러에서 해야 하는 일은 무엇일까?
 *    답) 클라이언트가 어떤 경로를 요청하면 그것을 어떤 서비스 비즈니스 로직으로 처리하고
 *    	어디로 어떻게 이동해서 응답해야 할지에 대한 작업만 하면 된다.
 */


//Annotation 딱지가 붙어있어야 컨트롤러의 역할을 할 수 있다.
public class MemberController2_backup {

   
   // spring bean container 로 부터 MemberDao 인터페이스 type 의 참조값을 DI 받는다. 
   @Autowired
   private MemberDao dao;
   
   // CREATE-----------------------------------------------
   @RequestMapping("/member/insertform")
   public ModelAndView insertform(ModelAndView mView) {
	   
	   //모델은 담지 않고 view page 의 정보만 담아서 리턴할 수 도 있다.
	   mView.setViewName("member/insertform");
	   return mView;
   }
   @RequestMapping("/member/insert")
   public ModelAndView insert(MemberDto dto) {
	   //MemberDao 객체를 이용해서 추가하기
	   dao.insert(dto);
	   // ModelAndView 객체의 생성자의 인자로 view page의 정보를 넣어줄 수도 있다.
	   return new ModelAndView("member/insert");
   }
   // CREATE-----------------------------------------------

   // READ-----------------------------------------------
   @RequestMapping("/member/list")
   public ModelAndView list() {
      
	  //view page 에 전달할 모델(data)
		List<MemberDto> list=dao.getList();
		
		//Model 과 view page의 정보를 동시에 담을 객체를 생성해서
		ModelAndView mView=new ModelAndView();
		// view page 에 전달한 모델을 list 라는 키값으로 담고
		mView.addObject("list", list);
		// view page 의 정보도 담고
		mView.setViewName("member/list");
		//ModelAndView 객체를 리턴해주면 동일하게 동작한다.
		return mView;
   }
   // READ-----------------------------------------------
   
   // UPDATE-----------------------------------------------
   @RequestMapping("/member/updateform")
   public String updateform(int num, HttpServletRequest request) {
		MemberDto dto=dao.getData(num);
		//view page에 전달할 모델(data)를 request 영역에 담는다.
		request.setAttribute("dto", dto);
		   
		List<MemberDto> list=dao.getList();
		request.setAttribute("list", list);
   
		return "member/updateform";
   }
   @RequestMapping("/member/update")
   public String update(MemberDto dto) {
		dao.update(dto);
		return "member/update";
   }
   // UPDATE-----------------------------------------------
   
   // DELETE -----------------------------------------------
   @RequestMapping("/member/deleteform")
   public String deleteform(HttpServletRequest request) {
      List<MemberDto> list=dao.getList();
      request.setAttribute("list", list);
	   return "member/deleteform";
   }
   @RequestMapping("/member/delete")
   public String delete(int num) {
		//MemberDto로 삭제
		dao.delete(num);
		// /member/list.do 요청을 다시 하도록 리다이렉트 이동시키기.
		// 리다이렉트 이동운 특정 경로로 요청을 다시 하라고 강요하는 응답이다.
		/*	
		 * 작성 방법 :
		 *  "redirect: context 경로를 제외한, 요청을 다시 할 절대 경로" 
		 */
		return "redirect:/member/list.do"; // context 경로는 필요 없다.
   }
   // DELETE-----------------------------------------------
   

}







