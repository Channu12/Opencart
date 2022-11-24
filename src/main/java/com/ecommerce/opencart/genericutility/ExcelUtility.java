package com.ecommerce.opencart.genericutility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String path , String sheetName , int rowNum , int cellNum) throws Exception
	{
		return WorkbookFactory.create(new FileInputStream(path)).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
}
