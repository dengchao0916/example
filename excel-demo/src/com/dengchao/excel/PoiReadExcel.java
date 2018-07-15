package com.dengchao.excel;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class PoiReadExcel {

	/**
	 * @Decription:
	 * @param args
	 * @return:void
	 */
	public static void main(String[] args) {
		File file = new File("e:/poi_text.xls");
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(
					FileUtils.openInputStream(file));
			HSSFSheet sheet = workbook.getSheetAt(0);
			int firstRowNum = 0;
			int lastRowNum = sheet.getLastRowNum();
			for (int i = firstRowNum; i <= lastRowNum; i++) {
				HSSFRow row = sheet.getRow(i);
				int lastCellNum = row.getLastCellNum();
				for (int j = 0; j < lastCellNum; j++) {
					HSSFCell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.print(value + "		");
				}
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
