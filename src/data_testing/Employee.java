package data_testing;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import base_class.BaseClass;
import page_factory.LoginPage;
import page_factory.EmployeePage;

public class Employee extends BaseClass {
	
	@Test(priority = 1)
	public void orderTest() throws Exception {
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
		
		EmployeePage order = PageFactory.initElements(driver, EmployeePage.class);
		order.changeOrderStatus();
		
		LoginPage cusLogin = PageFactory.initElements(driver, LoginPage.class);
		cusLogin.login("dotruonggiang@gmail.com", "dotruonggiang");
		
		driver.findElement(By.xpath(pro.getProperty("icon_cart"))).click();
		order.checkOrderStatus();
		driver.findElement(By.xpath(pro.getProperty("icon_user"))).click();
		driver.findElement(By.xpath(pro.getProperty("logout_account"))).click();
	};
	
	@Test(priority = 2)
	public void addCategory() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage empLogin = PageFactory.initElements(driver, LoginPage.class);
		empLogin.login("nhanvien@gmail.com", "123");
		
		EmployeePage addCategory = PageFactory.initElements(driver, EmployeePage.class);
		addCategory.addCategory();
	};
	
	@Test(priority = 3)
	public void updateCategory() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage updateCategory = PageFactory.initElements(driver, EmployeePage.class);
		updateCategory.updateCategory();
	};
	
	@Test(priority = 4)
	public void toggleCategory() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage changeStatusCategory = PageFactory.initElements(driver, EmployeePage.class);
		changeStatusCategory.changeStatusCategory();
	};
	
	@Test(priority = 5)
	public void addBook() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage empLogin = PageFactory.initElements(driver, LoginPage.class);
		empLogin.login("nhanvien@gmail.com", "123");
		
		EmployeePage addBook = PageFactory.initElements(driver, EmployeePage.class);
		addBook.addBook();
	};
	
	@Test(priority = 6)
	public void updateBook() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage updateBook = PageFactory.initElements(driver, EmployeePage.class);
		updateBook.updateBook();
	};
	
	@Test(priority = 7)
	public void toggleBook() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage toggleBook = PageFactory.initElements(driver, EmployeePage.class);
		toggleBook.toggleBook();
	};

}
