package login_testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import base_class.BaseClass;

public class CheckLogin extends BaseClass {
	
	@Test(description="This TC will check valid account to login to application")
	public void login() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File srcObject = new File("C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\Object_Repo.properties");
		 
		// Create  FileInputStream object
		FileInputStream fisObject = new FileInputStream(srcObject);
		 
		// Create Properties class object to read properties file
		Properties pro = new Properties();
		 
		// Load file so we can use into our script
		pro.load(fisObject);
		
		try {
			  File src=new File("C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\excelData\\accountData.xlsx");
			  FileInputStream fis = new FileInputStream(src);
			 
			  // load the workbook
			  XSSFWorkbook workbook = new XSSFWorkbook(fis);
			 
			  // get the sheet which you want to modify or create
			  XSSFSheet sheet1 = workbook.getSheetAt(0);
			  
			  driver.findElement(By.xpath(pro.getProperty("icon_user"))).click();
			  driver.findElement(By.xpath(pro.getProperty("login_account"))).click();
			 
			  //Iterate through each row from first sheet
			  Iterator<Row> rowIterator = sheet1.iterator();
			 
			  while (rowIterator.hasNext()) {
				  Row row = rowIterator.next();

				  //For each row iterate through each columns
				  Iterator <Cell> cellIterator = row.cellIterator();

				  while (cellIterator.hasNext()) {
					  Cell cell = cellIterator.next();
					  if(cell.getColumnIndex()==0) {
						  driver.findElement (By.xpath(pro.getProperty("emailLogin"))).sendKeys(cell.getStringCellValue());
					  } else if(cell.getColumnIndex()==1){
						  if(cell.getCellType() == cell.getCellType().NUMERIC) {
							  driver.findElement(By.xpath(pro.getProperty("passLogin"))).sendKeys(String.valueOf(cell.getNumericCellValue()));
						  } else {
							  driver.findElement(By.xpath(pro.getProperty("passLogin"))).sendKeys(cell.getStringCellValue());
						  };
					  } else{
						  break; 
					  };         
				  };
				  
				  driver.findElement(By.xpath(pro.getProperty("login_button"))).click();		  
				  
				  // Explicit wait condition for alert
				  WebDriverWait wait = new WebDriverWait(driver, 5);
				  Alert alert = null;
				  
				  try {
				      alert = wait.until(ExpectedConditions.alertIsPresent());
				  } catch(Exception e) {
					  System.out.println(e.getMessage());
				  };

				  if(alert == null) {
					  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pro.getProperty("icon_user")))).click();
				      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pro.getProperty("logout_account")))).click();
				      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pro.getProperty("icon_user")))).click();
				      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pro.getProperty("login_account")))).click();
					  sheet1.getRow(row.getRowNum()).createCell(2).setCellValue("Pass");
					  FileOutputStream foutPass = new FileOutputStream(new File("C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\excelData\\validAccount.xlsx"));
					  workbook.write(foutPass);
					  foutPass.close();
				  } else {
					  driver.switchTo().alert().accept();
					  sheet1.getRow(row.getRowNum()).createCell(2).setCellValue("Fail");
					  FileOutputStream foutFail = new FileOutputStream(new File("C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\excelData\\validAccount.xlsx"));
					  workbook.write(foutFail);
					  foutFail.close();
				  };
			  };
			 
			  workbook.close();
	    } catch (Exception e) {
			 System.out.println(e.getMessage());
	    };
	};
	
}
