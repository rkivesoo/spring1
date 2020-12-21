package com.spring.springajax;

public class PeopleVO {
//입력 받는 파라미터와 테이블에 있는 컬럼 값을 동일 하도록 설계 하자 그것이 다루기 편하다. 
	
	private String id;
	private String name;
	private String job;
	private String address;
	private String bloodtype;
	
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBloodtype() {
		return bloodtype;
	}
	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}
	
	
	
}
