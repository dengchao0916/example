package com.dengchao.excel;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JxlExpExcel {
	public static void main(String[] args) {
		String[] title = { "ID", "Name", "Position" };
		File file = new File("e:/jxl_text.xls");
		try {
			file.createNewFile();
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			Label label = null;
			for (int i = 0; i < title.length; i++) {
				// 第一个参数为列，第二个参数为行,第三个参数为内容
				label = new Label(i, 0, title[i]);
				sheet.addCell(label);
			}
			for (int i = 1; i < 10; i++) {
				label = new Label(0, i, "0000-" + i);
				sheet.addCell(label);
				label = new Label(1, i, "jack-" + i);
				sheet.addCell(label);
				label = new Label(2, i, "PM" + i);
				sheet.addCell(label);
			}
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
