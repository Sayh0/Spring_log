package com.gura.step03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.step03.member.dao.MemberDao;
import com.gura.step03.member.dto.MemberDto;

/*
 * 1. jackson=databind 라이브러리가 dependency 에 명시가 되어 있고,
 * 2. servlet-context.xml 에 <annotaion-driven> 명시되어 있고,
 * 3. 컨트롤러의 메소드에 @ResponseBody 어노테이션이 붙어 있으면
 *  >> Map or dto or List 객체에 담긴 내용이 json 문자열로 변환되어 응답된다.
 *  
 * 
 */


@Controller
public class JSONTestController {
	
	@RequestMapping("/send")
	@ResponseBody //리턴하는 Map을 클라이언트에게 바로 응답해줘라 라는 뜻. > Map 은 {K:V, K:V...} 형식으로 바뀌어서 사용자에게 응답된다.
	// Dto는 Dto의 field name이 나열되겠지.
	// 이 변환되는 과정은 jackson-databind 라이브러리가 알아서 해 준다.
	public Map<String, Object> send() {
		
		Map<String, Object> map=new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		
		return map;
	}
	@RequestMapping("/send2")
	@ResponseBody
	public MemberDto send2() {
		
		MemberDto dto=new MemberDto(2, "해골", "행신동");
		
		return dto;
	}
	@RequestMapping("/send3")
	@ResponseBody
	public List<String> send3(){
		
		List<String> list=new ArrayList<String>();
		list.add("한개");
		list.add("두개");
		list.add("세개");
		
		return list;
	}
	
	@Autowired
	private MemberDao dao;
	
	@RequestMapping("/send4")
	@ResponseBody
	public List<MemberDto> send4(){
		
		return dao.getList();
	}
}
