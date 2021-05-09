package data_testing;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base_class.BaseClass;
import page_factory.PageFac;

public class DataDriven extends BaseClass {

	@Test(priority = 1, description="This TC will get account data and export do excel")
	public void getAccountData() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFac getAccountData = PageFactory.initElements(driver, PageFac.class);
		getAccountData.exportAccountData();
	};
	
	@Test(priority = 2, description="This TC will get book data and export do excel")
	public void getBookData() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFac getBookData = PageFactory.initElements(driver, PageFac.class);
		getBookData.exportBookData();
	};
	
	@Test(priority = 3, dataProvider = "bookdata", description = "This TC will check book data")
	public void searchBook(String name) throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFac searchBook = PageFactory.initElements(driver, PageFac.class);
		if(name != null) {
			searchBook.searchBook(name, driver);
		};
	};
	
	@DataProvider(name = "bookdata", parallel = false)
	public Object[] TestDataFeed() throws Exception{
		
		Object[] book = new Object[16];
		
		File src=new File("C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\excelData\\BookData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		 
		// load the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 
		// get the sheet which you want to modify or create
		XSSFSheet sheet1 = workbook.getSheetAt(0);
		
		//Iterate through each row from first sheet
		Iterator<Row> rowIterator = sheet1.iterator();
		 
		while (rowIterator.hasNext()) {
			  Row row = rowIterator.next();
	
			  //For each row iterate through each columns
			  Iterator <Cell> cellIterator = row.cellIterator();
	
			  while (cellIterator.hasNext()) {
				  Cell cell = cellIterator.next(); 
				  if(cell.getColumnIndex() == 0 && row.getRowNum() >= 1) {
					  book[row.getRowNum()] = cell.getStringCellValue();  
				  };
			  };
		};
		
		workbook.close();
		return book;
	};
	
}
