package com.gura.step03.todo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.step03.todo.dto.TodoDto;

@Repository
public class TodoDaoImpl implements TodoDao{
	
	//Spring bean container 에서 SqlSession Type 객체를 찾아 주입(DI)하기 
	@Autowired
	//session 에는 초기엔 null값. @Autowired를 어노테이션 해서 여러 기능 추가.
	private SqlSession session;
	
	@Override
	public List<TodoDto> getList() {
		
		List<TodoDto> list=session.selectList("todo.getList");
		return list;
	}

	@Override
	public TodoDto getData(int num) {
		TodoDto a=session.selectOne("todo.getData", num);
		return a;
	}

	@Override
	public void insert(TodoDto dto) {
		session.insert("todo.insert", dto);
	}

	@Override
	public void update(TodoDto dto) {
		session.update("todo.update", dto);
	}

	@Override
	public void delete(int num) {
	    session.delete("todo.delete", num);
	}

}
