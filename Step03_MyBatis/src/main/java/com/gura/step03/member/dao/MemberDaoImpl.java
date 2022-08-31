package com.gura.step03.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.step03.member.dto.MemberDto;

//MemberDatoImpl 객체도 spring bean container 에서 관리가 되도록 한다.


//멤버DAO 구현Implement 클래스
@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired //spring bean container에서 SqlSession type 객체를 찾아서 주입해(DI)주세요 라는 의미.
	private SqlSession session; //session 은 초기엔 null값이 들어가있는데, @Autowired 덕분에 null이 아니게 되고 여러 기능을 가지게 됨.
	@Override
	public void insert(MemberDto dto) {
		  /*
	       *  Mapper's namespace : member
	       *  sql's id : insert
	       *  parameterType : MemberDto
	       */
		session.insert("member.insert", dto); //복잡한 insert 코드가 이렇게 줄었다!
	}

	@Override
	public void update(MemberDto dto) {
		  /*
	       *  Mapper's namespace : member
	       *  sql's id : update
	       *  parameterType : MemberDto
	       */
		session.update("member.update", dto);
	}

	@Override
	public void delete(int num) {
	    session.delete("member.delete", num);
	}

	@Override
	public MemberDto getData(int num) {
		  /*
	       *  Mapper's namespace :member
	       *  sql's id : update
	       *  parameterType : MemberDto
	       *  result type = MemberDto
	       */
		//row가 하나일 때 selectOne 사용. return type은 row가 어떤 것이냐에 따라 달라짐.
		//(맞춰서 쓰는 리턴타입) result=session.selectOne("xxx.xxx");
		MemberDto a=session.selectOne("member.getData", num);
		
		return a;
	}

	@Override
	public List<MemberDto> getList() {
		/*
		 *  Mapper's namespace ; member
		 *  sql's id= getlist
		 *  parameterType : 없음
		 *  resultType : MemberDto
		 */
		
		List<MemberDto> list=session.selectList("member.getList");
		           		
		return list;
	}

}
