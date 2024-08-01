package tutorialsproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HandleExcelFiles {
	
	public static void main(String[] args) throws IOException {
		
		String excelPath = System.getProperty("user.dir")+"//Files//empdata.xlsx";
		File f = new File(excelPath);
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("emp_data");
		int rows= sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		for(int r=0;r<=rows;r++) {
			XSSFRow row=sheet.getRow(r);
			for(int c=0;c<cols;c++ ) {
				XSSFCell cell=row.getCell(c);
				CellType cellType= cell.getCellType();
				switch(cellType) {
				
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
		
		
	}

}
