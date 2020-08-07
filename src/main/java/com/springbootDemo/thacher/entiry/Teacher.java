package com.springbootDemo.thacher.entiry;

import com.springbootDemo.annotation.ExcelAnno;

/**
 * 老师类
 * 
 * @author wqk
 * @version 1.0
 * 
 */
public class Teacher {
	/**
	 * 姓名
	 */
	@ExcelAnno(fieldValue = "姓名", fieldName = "name")
	private String name;
	/**
	 * 年龄
	 */
	@ExcelAnno(fieldValue = "年龄", fieldName = "age")
	private Integer age;
	/**
	 * 学历
	 */
	@ExcelAnno(fieldValue = "学历", fieldName = "education")
	private String education;
	/**
	 * 课程
	 */
	@ExcelAnno(fieldValue = "课程", fieldName = "curriculum")
	private String curriculum;
	/**
	 * 身高
	 */
	@ExcelAnno(fieldValue = "身高", fieldName = "heigth")
	private Double heigth;
	/**
	 * 体重
	 */
	@ExcelAnno(fieldValue = "体重", fieldName = "weight")
	private Double weight;

	public Teacher() {

	}

	public Teacher(String name, Integer age, String education, String curriculum, Double heigth, Double weight) {
		super();
		this.name = name;
		this.age = age;
		this.education = education;
		this.curriculum = curriculum;
		this.heigth = heigth;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public Double getHeigth() {
		return heigth;
	}

	public void setHeigth(Double heigth) {
		this.heigth = heigth;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", education=" + education + ", curriculum=" + curriculum
				+ ", heigth=" + heigth + ", weight=" + weight + "]";
	}

}
