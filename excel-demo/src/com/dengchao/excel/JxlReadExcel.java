package com.dengchao.excel;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class JxlReadExcel {

	/**
	 * @Decription:
	 * @param args
	 * @return:void
	 */
	public static void main(String[] args) {
		try {
			Workbook workbook = Workbook
					.getWorkbook(new File("e:/jxl_text.xls"));
			Sheet sheet = workbook.getSheet(0);
			for (int i = 0, rowLength = sheet.getRows(); i < rowLength; i++) {
				for (int j = 0, columnLength = sheet.getColumns(); j < columnLength; j++) {
					Cell cell = sheet.getCell(j, i);
					System.out.print(cell.getContents() + "		");
				}
				System.out.println();

			}
			workbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
