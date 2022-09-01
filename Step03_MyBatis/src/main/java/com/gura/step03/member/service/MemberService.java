package com.gura.step03.member.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.step03.member.dto.MemberDto;

public interface MemberService {
	//회원정보 추가 메소드
	public void addMember(MemberDto dto);
	//회원정보 수정 메소드
	public void updateMember(MemberDto dto);
	//회원정보 삭제 메소드
	public void deleteMember(int num);
	//회원 한명의 정보를 인자로 전달한 ModelAndView 객체에 담아주는 메소드
	public void getMember(int num, ModelAndView mView);
	//회원 전체의 정보를 인자로 전달한 ModelAndView 객체에 담아주는 메소드
	public void getListMember(ModelAndView mView);
}
