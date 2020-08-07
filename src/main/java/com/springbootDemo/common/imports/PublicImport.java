package com.springbootDemo.common.imports;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * 公共导出类 实现excel表格导入导出
 * 
 * @author wqk
 * @version 1.0
 * 
 */
public class PublicImport extends ImportReflex {

	private static final String GETER = "get";

	/**
	 * 创建行时的索引
	 */
	private static int num = 1;

	public PublicImport(Class<?> clas) {
		super(clas);
	}

	/**
	 * 创建excel表格对象
	 * 
	 * @return
	 */
	@Override
	public HSSFWorkbook createHssfWorkbook() {
		if (hSSFWorkbook != null) {
			return hSSFWorkbook;
		}
		return new HSSFWorkbook();
	}

	@Override
	public HSSFSheet initHssfWorkbook(HSSFWorkbook wb, String sheetName, String cellName) {
		// 获取表字段和值的键值对集合
		LinkedHashMap<String, String> map = ImportReflex.getColumnMap();
		// 创建sheet对象
		HSSFSheet sheet = wb.createSheet(sheetName);
		// 创建sheet第一行
		HSSFRow row = sheet.createRow(0);
		// 创建单元格
		HSSFCell cell = row.createCell(0);
		// 设置单元格内容
		cell.setCellValue(cellName);
		cell.setCellStyle(setCellStyle(wb, HSSFCellStyle.ALIGN_CENTER));
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, map.size() - 1));
		// 创建sheet第二行
		HSSFRow row1 = sheet.createRow(1);

		int number = 0;

		for (String key : map.keySet()) {
			cell = row1.createCell(number++);
			cell.setCellValue(map.get(key));
			cell.setCellStyle(setCellStyle(wb, HSSFCellStyle.ALIGN_CENTER));
		}
		return sheet;
	}

	@Override
	public Boolean generateRowData(HSSFWorkbook wb, HSSFSheet sheet, ArrayList<?> list, String path) throws Exception {
		HSSFRow row = null;
		HSSFCell cell = null;
		LinkedHashMap<String, String> map;
		Class<?> clas;
		for (int i = 0; i < list.size(); i++) {
			int number = 0;
			// 创建行对象
			row = sheet.createRow(++num);
			clas = list.get(i).getClass();
			map = ImportReflex.getColumnMap();
			for (String key : map.keySet()) {
				Method mt = clas.getMethod(fieldStr(key));
				// 调用get方法
				Object vals = mt.invoke(list.get(i));
				cell = row.createCell(number++);
				if (vals instanceof Integer) {
					setCellValue(vals, cell);
				} else if (vals instanceof Double) {
					setCellValue(vals, cell);
				} else {
					setCellValue(vals, cell);
				}
				cell.setCellStyle(setCellStyle(wb, HSSFCellStyle.ALIGN_CENTER));
			}
		}
		OutputStream os = null;
		try {
			os = new FileOutputStream(path);
			wb.write(os);
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		} finally {
			if (os != null) {
				os.close();
				os.flush();
			}
		}
		return Boolean.TRUE;
	}

	@Override
	public HSSFCellStyle setCellStyle(HSSFWorkbook wb, short style) {
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(style);
		return cellStyle;
	}

	/**
	 * 判断返回值类型
	 * 
	 * @param obj
	 * @return
	 */
	public static void setCellValue(Object val, HSSFCell cell) {

		if (val instanceof Integer) {
			cell.setCellValue((int) val);
		}
		if (val instanceof String) {
			cell.setCellValue((String) val);
		}
		if (val instanceof Double) {
			cell.setCellValue((double) val);
		}

	}

	/**
	 * 获取get方法
	 * 
	 * @param key
	 * @return
	 */
	public static String fieldStr(String key) {
		return GETER + key.replaceFirst(key.substring(0, 1), key.substring(0, 1).toUpperCase());
	}
}
