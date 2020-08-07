package com.springbootDemo.common.imports;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.springbootDemo.annotation.ExcelAnno;
import com.springbootDemo.common.exception.MyRunException;

/**
 * 反射抽象类
 * 
 * @author wqk
 * @version 1.0
 * 
 */
public abstract class ImportReflex {

	/**
	 * 用来存储表格列字段名与值
	 */
	private static final LinkedHashMap<String, String> COLUMN_MAP = new LinkedHashMap<String, String>();

	private static Class<?> clas;

	protected static HSSFWorkbook hSSFWorkbook;

	public ImportReflex(Class<?> clas) {
		this.clas = clas;
		addField(clas);
	}

	public static Class<?> getObj() {
		return clas;
	}

	public static LinkedHashMap<String, String> getColumnMap() {
		return COLUMN_MAP;
	}

	/**
	 * 初始化表头字段名与值
	 * 
	 * @param obj
	 * @return
	 */
	private static LinkedHashMap<String, String> addField(Class<?> clas) {
		Field[] fields = clas.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (!fields[i].isAnnotationPresent(ExcelAnno.class)) {
				continue;
			}
			ExcelAnno columnName = fields[i].getAnnotation(ExcelAnno.class);
			if (columnName.fieldName() == null || columnName.fieldName().equals("")) {
				throw new MyRunException("标记列名时缺少fieldName属性", 2);
			}
			if (columnName.fieldValue() == null || columnName.fieldValue().equals("")) {
				throw new MyRunException("标记列名时缺少fieldValue属性", 2);
			}
			COLUMN_MAP.put(columnName.fieldName(), columnName.fieldValue());
		}
		return COLUMN_MAP;
	}

	/**
	 * 创建表格对象
	 * 
	 * @return
	 */
	public abstract HSSFWorkbook createHssfWorkbook();

	/**
	 * 初始化表格
	 * 
	 * @param wb
	 * @param sheetName
	 * @param cellName
	 * @param cla
	 * @return
	 */
	public abstract HSSFSheet initHssfWorkbook(HSSFWorkbook wb, String sheetName, String cellName);

	/**
	 * 生成行数据
	 * 
	 * @param wb
	 * @param sheet
	 * @param list
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public abstract Boolean generateRowData(HSSFWorkbook wb, HSSFSheet sheet, ArrayList<?> list, String path)
			throws Exception;

	/**
	 * 设置单元格样式
	 * 
	 * @param wb
	 * @param style
	 * @return
	 */
	public abstract HSSFCellStyle setCellStyle(HSSFWorkbook wb, short style);
}
