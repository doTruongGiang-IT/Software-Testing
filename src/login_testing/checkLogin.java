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
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import base_class.BaseClass;

public class checkLogin extends BaseClass {
	
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
			  FileInputStream fis=new FileInputStream(src);
			 
			  // load the workbook
			  XSSFWorkbook workbook=new XSSFWorkbook(fis);
			 
			  // get the sheet which you want to modify or create
			  XSSFSheet sheet1= workbook.getSheetAt(0);
			  
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
						  driver.findElement(By.xpath(pro.getProperty("passLogin"))).sendKeys(cell.getStringCellValue());
					  } else{
						  break; 
					  };         
				  };
				  
				  driver.findElement(By.xpath(pro.getProperty("login_button"))).click();
			   
				  // Explicit wait condition for alert
				  WebDriverWait waiter = new WebDriverWait(driver, 5);
				  //alertIsPresent() condition applied
				  if(waiter.until(ExpectedConditions.alertIsPresent()) != null) {
					  driver.switchTo().alert().accept();
					  sheet1.getRow(row.getRowNum()).createCell(2).setCellValue("Fail");
					  FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\excelData\\validAccount.xlsx"));
					  workbook.write(fout);
					  fout.close();
				  } else {
					  driver.navigate().back();
					  Thread.sleep(2000);
					  sheet1.getRow(row.getRowNum()).createCell(2).setCellValue("Pass");
					  FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\excelData\\validAccount.xlsx"));
					  workbook.write(fout);
					  fout.close();
				  };
			  };
			 
			  workbook.close();
	    } catch (Exception e) {
			 System.out.println(e.getMessage());
	    };
	};
	
}
