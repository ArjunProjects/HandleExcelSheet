package tutorialsproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HandleExcelFilesWay2 {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//Files//empdata.xlsx");
		
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheet("emp_data");
		Iterator<Row> itrRow = sheet.iterator();
		while(itrRow.hasNext()) {
			Row row = itrRow.next();
			Iterator<Cell>itrCell=row.iterator();
			while(itrCell.hasNext()) {
				Cell cell = itrCell.next();
				CellType cellType = cell.getCellType();
				switch(cellType) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				default:
					break;
				}
				System.out.print(" ");
			}
			System.out.println();
			
			
		}
		
		workBook.close();
		
	}

}
