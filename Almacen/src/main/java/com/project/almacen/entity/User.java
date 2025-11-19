package com.project.almacen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class User {
	@TableId(value = "id",type = IdType.AUTO)
	private int id;
	private String no;
	private String name;
	private String password;
	private int age;
	private int sex;
	@TableField("role_id")
	private int roleId;
	private String phone;
	@TableField("isValid")
	private String isValid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getRoled() {
		return roleId;
	}
	public void setRoled(int roled) {
		this.roleId = roled;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", no=" + no + ", name=" + name + ", password=" + password + ", age=" + age + ", sex="
				+ sex + ", roled=" + roleId + ", phone=" + phone + ", isValid=" + isValid + "]";
	}
	
	
}
