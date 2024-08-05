package tutorialsproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingtoExcel {
	
	public static void main(String args[]) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("SheetOne");
		
		Object[][] data = {
				{"Name","Company","WorkLocation","Experience"},
				{"athul","HCL","Hyd",5},
				{"vimal","TechMahindra","Bangalore",10},
				{"shyamala","Infosys","Delhi",2}
		};
		
		int rows=data.length;
		int colms = data[0].length;
		for(int r=0;r<rows;r++) {
			XSSFRow row=sheet.createRow(r);
			for(int c=0;c<colms;c++) {
				XSSFCell cell = row.createCell(c);
				Object cellValue=data[r][c];
//				CellType cellType = cell.getCellType();
				if(cellValue instanceof String) {
					cell.setCellValue((String)cellValue);
				}else if(cellValue instanceof Integer) {
					cell.setCellValue((Integer)cellValue);
				}else if(cellValue instanceof Boolean) {
					cell.setCellValue((Boolean)cellValue);
				}else {
					System.out.println("invalid data type entered");
				}
			}
		}
		
		File f = new File(System.getProperty("user.dir")+"//Files//Employees.xlsx");
		FileOutputStream fos = new FileOutputStream(f);
		try {
			workbook.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workbook.close();
		System.out.println("workbook has been created with data");
		
	}

}
