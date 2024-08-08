package tutorialsproject;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDataProviders extends Base {
	
	@Test(dataProvider="supplier")
	public void loginTest(String email, Double password) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(email);
		int pass = password.intValue();
		driver.findElement(By.id("input-password")).sendKeys(String.valueOf(pass));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	
	@DataProvider(name="supplier")
	public Object[][] dataSupplier() throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook(getFilePath());
		XSSFSheet sheet = workbook.getSheet("login");
		int rows= sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		System.out.println("rows"+rows);
		System.out.println("cols"+cols);
		Object[][] data = new Object[rows-1][cols];
		for(int r=0;r<rows-1;r++) {
			XSSFRow row=sheet.getRow(r+1);
			for(int c=0;c<cols;c++ ) {
				XSSFCell cell=row.getCell(c);
				
				CellType cellType= cell.getCellType(); 
				switch(cellType) {
				
				case STRING:
					data[r][c]=cell.getStringCellValue();
					System.out.println(data[r][c]);
					break;
				case NUMERIC:
					data[r][c]=cell.getNumericCellValue();
					System.out.println(data[r][c]);
					break;
				}
				
			}
			
		}
		
			return data;
		
	}
		
	}

