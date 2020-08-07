package com.springbootDemo.common.imports;

import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.springbootDemo.car.entriy.Car;

public class Test {

	public static final String PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\excel";

	public static void main(String[] args) {
		// 创建对象并初始化列头
		PublicImport imports = new PublicImport(Car.class);
		// 创建excel对象
		HSSFWorkbook wb = imports.createHssfWorkbook();
		// 初始化表格
		HSSFSheet sheet = imports.initHssfWorkbook(wb, "汽车表", "汽车信息一览表");
		Car car = new Car("奔驰", 1000000.0, "3.0T", "白色", "轿车", "S级", 5.0);
		Car car2 = new Car("宝马", 1000000.0, "3.0T", "白色", "轿车", "8系", 5.0);
		Car car3 = new Car("奥迪", 1000000.0, "3.0T", "白色", "轿车", "A6L", 5.0);
		Car car4 = new Car("比亚迪", 250000.0, "3.0T", "白色", "轿车", "汉", 5.0);
		Car car5 = new Car("北京", 300000.0, "3.0T", "白色", "轿车", "", 5.0);
		Car car6 = new Car("福特", 250000.0, "3.0T", "白色", "轿车", "金牛座", 5.0);
		Car car7 = new Car("大众", 250000.0, "3.0T", "白色", "轿车", "CC", 5.0);
		ArrayList<Car> list = new ArrayList<>();
		list.add(car);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		list.add(car5);
		list.add(car6);
		list.add(car7);

		boolean ok;
		try {
			ok = imports.generateRowData(wb, sheet, list, PATH + "\\教师表测试.xls");
			if (ok) {
				System.out.println("excel已生成-------------");
			} else {
				System.out.println("excel生成失败-----------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
