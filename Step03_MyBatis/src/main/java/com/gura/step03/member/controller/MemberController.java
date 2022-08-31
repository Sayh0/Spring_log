package com.gura.step03.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gura.step03.member.dao.MemberDao;
import com.gura.step03.member.dto.MemberDto;

@Controller
public class MemberController {
   
   // spring bean container 로 부터 MemberDao 인터페이스 type 의 참조값을 DI 받는다. 
   @Autowired
   private MemberDao dao;
   
   
   //추가완료
   @RequestMapping("/member/insert")
   public String insert(MemberDto dto) {
	   //MemberDao 객체를 이용해서 추가하기
	   dao.insert(dto);
	   //view page 로 forward 이동해서 응답하기
	   return "member/insert";
   }
   //추가
   @RequestMapping("/member/insertform")
   public String insertform() {
	   return "member/insertform";
   }
   
   //삭제
   @RequestMapping("/member/deleteform")
   public String deleteform(HttpServletRequest request) {
      List<MemberDto> list=dao.getList();
      request.setAttribute("list", list);
	   return "member/deleteform";
   }
   
   //삭제완료
   @RequestMapping("/member/delete")
   public String delete(int num) {
		//MemberDto로 삭제
		dao.delete(num);
		return "member/delete";
   }
   
   //UPDATE
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
   
   
   
   @RequestMapping("/member/list")
   public String list(HttpServletRequest request) {
      
      
		List<MemberDto> list=dao.getList();
		request.setAttribute("list", list);
      /*
       *  /WEB-INF/views/member/list.jsp 페이지로 forward 이동해서 
       *  회원 목록을 출력하면된다.
       *  
       *  그런데... 회원목록은 어떻게 얻어오지? 
       */
      return "member/list";
   }
}








