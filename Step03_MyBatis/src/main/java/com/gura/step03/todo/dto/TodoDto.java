package com.gura.step03.todo.dto;

public class TodoDto {
	//field
	private int num;
	private String content;
	private String regdate;
	//constructor
	public TodoDto() {}
	public TodoDto(int num, String content, String regdate) {
		this.num = num;
		this.content = content;
		this.regdate = regdate;
	}
	//GetterSetter
	public int getNum() {return num;}
	public void setNum(int num) {this.num = num;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public String getRegdate() {return regdate;}
	public void setRegdate(String regdate) {this.regdate = regdate;}
	
	
	
}
