package com.springbootDemo.student.entiry;

import com.springbootDemo.annotation.ExcelAnno;

/**
 * 学生类
 * 
 * @author wqk
 * @version 1.0
 * 
 */
public class Student {

	/**
	 * 姓名
	 */
	@ExcelAnno(fieldValue = "姓名", fieldName = "name")
	public String name;
	/**
	 * 班级
	 */
	@ExcelAnno(fieldValue = "班级", fieldName = "clasz")
	public String clasz;
	/**
	 * 成绩
	 */
	@ExcelAnno(fieldValue = "成绩", fieldName = "achiEvement")
	public Double achiEvement;
	/**
	 * 身高
	 */
	@ExcelAnno(fieldValue = "身高", fieldName = "height")
	public Double height;
	/**
	 * 年龄
	 */
	@ExcelAnno(fieldValue = "年龄", fieldName = "age")
	public Integer age;

	public Student() {

	}

	public static void main(String[] args) {
		String name = "achiEvement";
		String filestr = name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());
		System.out.println(filestr);
	}

	public Student(String name, String clasz, Double achiEvement, Double height, Integer age) {
		super();
		this.name = name;
		this.clasz = clasz;
		this.achiEvement = achiEvement;
		this.height = height;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasz() {
		return clasz;
	}

	public void setClasz(String clasz) {
		this.clasz = clasz;
	}

	public Double getAchiEvement() {
		return achiEvement;
	}

	public void setAchiEvement(Double achiEvement) {
		this.achiEvement = achiEvement;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", clasz=" + clasz + ", achiEvement=" + achiEvement + ", height=" + height
				+ ", age=" + age + "]";
	}

}
