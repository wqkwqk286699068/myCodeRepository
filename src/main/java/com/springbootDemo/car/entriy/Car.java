package com.springbootDemo.car.entriy;

import com.springbootDemo.annotation.ExcelAnno;

/**
 * 汽车类
 * 
 * @author wqk
 * @version 1.0
 *
 */
public class Car {
	@ExcelAnno(fieldName = "pinPai", fieldValue = "品牌")
	private String pinPai;

	@ExcelAnno(fieldName = "jiaGe", fieldValue = "价格")
	private Double jiaGe;

	@ExcelAnno(fieldName = "paiLiang", fieldValue = "排量")
	private String paiLiang;

	@ExcelAnno(fieldName = "color", fieldValue = "颜色")
	private String color;

	@ExcelAnno(fieldName = "type", fieldValue = "类型")
	private String type;

	@ExcelAnno(fieldName = "cheType", fieldValue = "车型")
	private String cheType;

	@ExcelAnno(fieldName = "changDu", fieldValue = "长度")
	private Double changDu;

	public String getPinPai() {
		return pinPai;
	}

	public void setPinPai(String pinPai) {
		this.pinPai = pinPai;
	}

	public Double getJiaGe() {
		return jiaGe;
	}

	public void setJiaGe(Double jiaGe) {
		this.jiaGe = jiaGe;
	}

	public String getPaiLiang() {
		return paiLiang;
	}

	public void setPaiLiang(String paiLiang) {
		this.paiLiang = paiLiang;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCheType() {
		return cheType;
	}

	public void setCheType(String cheType) {
		this.cheType = cheType;
	}

	public Double getChangDu() {
		return changDu;
	}

	public void setChangDu(Double changDu) {
		this.changDu = changDu;
	}

	public Car(String pinPai, Double jiaGe, String paiLiang, String color, String type, String cheType,
			Double changDu) {
		super();
		this.pinPai = pinPai;
		this.jiaGe = jiaGe;
		this.paiLiang = paiLiang;
		this.color = color;
		this.type = type;
		this.cheType = cheType;
		this.changDu = changDu;
	}

	@Override
	public String toString() {
		return "Car [pinPai=" + pinPai + ", jiaGe=" + jiaGe + ", paiLiang=" + paiLiang + ", color=" + color + ", type="
				+ type + ", cheType=" + cheType + ", changDu=" + changDu + "]";
	}

}
