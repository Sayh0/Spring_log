package com.gura.step03.member.dao;

import java.util.List;

import com.gura.step03.member.dto.MemberDto;

//인터페이스를 이용해 모양을 미리 만들어 놓는다. 인터페이스를 활용해 객체들의 관계를 느슨하게.
public interface MemberDao {
	public void insert(MemberDto dto);
	public void update(MemberDto dto);
	public void delete(int num);
	public MemberDto getData(int num);
	public List<MemberDto> getList();
}
