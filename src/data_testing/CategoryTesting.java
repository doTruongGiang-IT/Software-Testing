package data_testing;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import base_class.BaseClass;
import page_factory.EmployeePage;
import page_factory.LoginPage;

public class CategoryTesting extends BaseClass {

	int id = ((int) (Math.random()*(100 - 10))) + 10;
	String message = "Hãy nhập hết tất cả các thông tin";
	
	@Test(priority = 1)
	public void inValidAddCategoryID() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File srcObject = new File("C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\Object_Repo.properties");
		 
		// Create  FileInputStream object
		FileInputStream fisObject = new FileInputStream(srcObject);
		 
		// Create Properties class object to read properties file
		Properties pro = new Properties();
		 
		// Load file so we can use into our script
		pro.load(fisObject);
		LoginPage empLogin = PageFactory.initElements(driver, LoginPage.class);
		empLogin.login("nhanvien@gmail.com", "123");
		
		EmployeePage addCategory = PageFactory.initElements(driver, EmployeePage.class);
		addCategory.manageCategory("", "My book");
		List<String> categories = new ArrayList<String>();
		int rowCount = driver.findElements(By.xpath(pro.getProperty("rowCategories"))).size();
		for(int i = 1; i <= rowCount; i++) {
			String categoryName = driver.findElement(By.xpath("//*[@id=\"datatable\"]/tbody/tr[" + i + "]/td[2]")).getText();
			categories.add(categoryName);
		};
		for(String name : categories) {
			if(name.contains("My book")) {
				System.out.println("Bug in here");
			}else {
				System.out.println("Test passed");
			};
		};
	};
	
	@Test(priority = 2)
	public void inValidAddCategoryName() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage addCategory = PageFactory.initElements(driver, EmployeePage.class);
		addCategory.addCategory(String.valueOf(id), "");
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("Alert message: " + alertMessage);
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 3)
	public void inValidAddCategoryID_Name() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage addCategory = PageFactory.initElements(driver, EmployeePage.class);
		addCategory.addCategory("", "");
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("Alert message: " + alertMessage);
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 4)
	public void validAddCategory() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String name = "Book of life";
		File srcObject = new File("C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\Object_Repo.properties");
		 
		// Create  FileInputStream object
		FileInputStream fisObject = new FileInputStream(srcObject);
		 
		// Create Properties class object to read properties file
		Properties pro = new Properties();
		 
		// Load file so we can use into our script
		pro.load(fisObject);
		
		EmployeePage addCategory = PageFactory.initElements(driver, EmployeePage.class);
		addCategory.addCategory(String.valueOf(id), name);
		
		List<String> categories = new ArrayList<String>();
		int rowCount = driver.findElements(By.xpath(pro.getProperty("rowCategories"))).size();
		for(int i = 1; i <= rowCount; i++) {
			String categoryName = driver.findElement(By.xpath("//*[@id=\"datatable\"]/tbody/tr[" + i + "]/td[2]")).getText();
			categories.add(categoryName);
		};
		if(categories.contains(name)) {
			System.out.println("Test passed");
		}else {
			System.out.println("Bug in here");
		};
	};
	
	@Test(priority = 5)
	public void inValidUpdateCategory() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage updateCategory = PageFactory.initElements(driver, EmployeePage.class);
		updateCategory.updateCategory("");
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("Alert message: " + alertMessage);
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 6)
	public void validUpdateCategory() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage updateCategory = PageFactory.initElements(driver, EmployeePage.class);
		updateCategory.updateCategory("Sách kỹ thuật lập trình nâng cao");
	};
	
	@Test(priority = 7)
	public void toggleCategory() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String status = driver.findElement(By.xpath("//*[@id=\"datatable\"]/tbody/tr[1]/td[3]")).getText();
		if(status.contains("0")) {
			System.out.println("Category status before: Hiển thị");
		}else {
			System.out.println("Category status before: Ẩn");
		};
		EmployeePage changeStatusCategory = PageFactory.initElements(driver, EmployeePage.class);
		changeStatusCategory.changeStatusCategory(driver);
	};
	
}
