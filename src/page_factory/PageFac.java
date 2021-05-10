package page_factory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFac {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"wn__header\"]/div/div[1]/div[3]/ul/li[1]/a")
	@CacheLookup
	WebElement icon_search;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"search_mini_form\"]/div/input[1]")
	@CacheLookup
	WebElement searchInput;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"search_mini_form\"]/div/div/button")
	@CacheLookup
	WebElement search_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"nav-grid\"]/div/div/div[2]/h4/a")
	@CacheLookup
	WebElement searchItem;
	
	public void exportAccountData() {
		String jdbcURL = "jdbc:mysql://localhost:3306/webdb?useSSL=false";
        String username = "root";
        String password = "";
 
        String excelFilePath = "C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\excelData\\Account.xlsx";
 
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM tbltaikhoan";
 
            Statement statement = connection.createStatement();
 
            ResultSet result = statement.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("AccountData");
 
            Row headerRow = sheet.createRow(0);
            
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Email");
     
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Password");
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Roll");
 
            int rowCount = 1;
            
            while (result.next()) {
                String email = result.getString("email");
                String pass = result.getString("matkhau");
                String roll = result.getString("capbac");
     
                Row row = sheet.createRow(rowCount++);
     
                int columnCount = 0;
                Cell cell = row.createCell(columnCount++);
                cell.setCellValue(email);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(pass);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(roll);
            };
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
 
            statement.close();
 
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        };
	};
	
	public void exportBookData() {
		String jdbcURL = "jdbc:mysql://localhost:3306/webdb?useSSL=false";
        String username = "root";
        String password = "";
 
        String excelFilePath = "C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\excelData\\BookData.xlsx";
 
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM tblsach";
 
            Statement statement = connection.createStatement();
 
            ResultSet result = statement.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("BookData");
 
            Row headerRow = sheet.createRow(0);
            
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Ten Sach");
     
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Gia Ban");
 
            int rowCount = 1;
            
            while (result.next()) {
                String name = result.getString("tenSach");
                String price = result.getString("GiaBan");
     
                Row row = sheet.createRow(rowCount++);
     
                int columnCount = 0;
                Cell cell = row.createCell(columnCount++);
                cell.setCellValue(name);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(price);
            };
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
 
            statement.close();
 
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        };
	};
	
	public void searchBook(String name, WebDriver driver) throws Exception {
		icon_search.click();
		Thread.sleep(2000);
		searchInput.sendKeys(name);
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.elementToBeClickable(search_button)).click();
		if(searchItem.getText().toLowerCase().contains(name.toLowerCase())) {
			System.out.println("Book name: " + searchItem.getText());
		};
	};

}
