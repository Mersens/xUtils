package com.example.android_xutilstest;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

@Table(name = "User")
public class UserBean {
	@Id(column = "id")
	private String id;
	@Column(column = "name")
	private String name;
	@Column(column = "sex")
	private String sex;
	@Column(column = "age")
	private int age;

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + "]";
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
