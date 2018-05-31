package com.dengchao.bean;

public class Student {
	private String name;
	private String age;
	private String gender;
	private String phone;
	private String address;

	public Student() {

	}

	public Student(String name, String age, String gender, String phone,
			String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String string) {
		this.age = string;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "姓名:" + this.name + " 年龄:" + this.age + " 性别:" + this.gender
				+ " 电话:" + this.phone + " 地址:" + this.address;
	}

}
