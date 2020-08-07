package com.springbootDemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 导入导出excel表格注解，使用注解标记的字段视为表格列名，列名必须为string类型
 * 
 * @author wqk
 * 
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelAnno {

	/**
	 * 字段值
	 * 
	 * @return
	 */
	String fieldValue();

	/**
	 * 字段名
	 * 
	 * @return
	 */
	String fieldName();

}
