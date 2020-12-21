/*
 *     
       create table tab_mybatis (
       id varchar2(15) primary key,
       name varchar2(15),
       email varchar2(50),
       phone varchar2(15)
       );
 * */

package com.spring.springmybatis;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private int age;
	private String email;	
	private String gender;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + ", email=" + email
				+ ", gender=" + gender + "]";
	}
	
	
	

}
