package data_testing;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import base_class.BaseClass;
import page_factory.EmployeePage;
import page_factory.LoginPage;

public class BookTesting extends BaseClass {
	
	String message = "Hãy nhập hết tất cả các thông tin";
	
	@Test(priority = 1)
	public void inValidAddBookName() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage empLogin = PageFactory.initElements(driver, LoginPage.class);
		empLogin.login("nhanvien@gmail.com", "123");
		
		EmployeePage addBook = PageFactory.initElements(driver, EmployeePage.class);
		addBook.addBook("", "110", "Can not add book because a book required a name",
						"5", "C:\\Users\\DELL\\OneDrive\\Hình ảnh\\Saved Pictures\\Nhà_giả_kim_(sách).jpg");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 2)
	public void inValidAddBookPrice() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage addBook = PageFactory.initElements(driver, EmployeePage.class);
		addBook.addBook("Nha gia kim", "", "Can not add book because a book required a price",
				"5", "C:\\Users\\DELL\\OneDrive\\Hình ảnh\\Saved Pictures\\Nhà_giả_kim_(sách).jpg");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 3)
	public void inValidAddBookImage() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage addBook = PageFactory.initElements(driver, EmployeePage.class);
		addBook.addBook("Nha gia kim", "110", "Can not add book because a book required an image",
				"5", "");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 4)
	public void inValidAddBookName_Price() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage addBook = PageFactory.initElements(driver, EmployeePage.class);
		addBook.addBook("", "", "Can not add book because a book required both name and price",
				"5", "C:\\Users\\DELL\\OneDrive\\Hình ảnh\\Saved Pictures\\Nhà_giả_kim_(sách).jpg");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 5)
	public void inValidAddBookName_Image() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage addBook = PageFactory.initElements(driver, EmployeePage.class);
		addBook.addBook("", "110", "Can not add book because a book required both name and image",
				"5", "");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 6)
	public void inValidAddBookPrice_Image() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage addBook = PageFactory.initElements(driver, EmployeePage.class);
		addBook.addBook("Nha gia kim", "", "Can not add book because a book required both price and image",
				"5", "");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 7)
	public void inValidAddBookName_Price_Iamge() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage addBook = PageFactory.initElements(driver, EmployeePage.class);
		addBook.addBook("", "", "Can not add book because a book required name - price - image",
				"5", "");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};

	@Test(priority = 8)
	public void validAddBook() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage addBook = PageFactory.initElements(driver, EmployeePage.class);
		addBook.addBook("Nha gia kim", "110", "This is valid book data, ready to push it into table",
				"5", "C:\\Users\\DELL\\OneDrive\\Hình ảnh\\Saved Pictures\\Nhà_giả_kim_(sách).jpg");
	};
	
	@Test(priority = 9)
	public void inValidUpdateBookName() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage updateBook = PageFactory.initElements(driver, EmployeePage.class);
		updateBook.updateBook("", "120", "C:\\Users\\DELL\\OneDrive\\Hình ảnh\\Cuộn phim\\monster.jpg");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 10)
	public void inValidUpdateBookPrice() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage updateBook = PageFactory.initElements(driver, EmployeePage.class);
		updateBook.updateBook("Harry Potter", "", "C:\\Users\\DELL\\OneDrive\\Hình ảnh\\Cuộn phim\\monster.jpg");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 11)
	public void inValidUpdateBookImage() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage updateBook = PageFactory.initElements(driver, EmployeePage.class);
		updateBook.updateBook("Harry Potter", "120", "");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 12)
	public void inValidUpdateBookName_Price() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage updateBook = PageFactory.initElements(driver, EmployeePage.class);
		updateBook.updateBook("", "", "C:\\Users\\DELL\\OneDrive\\Hình ảnh\\Cuộn phim\\monster.jpg");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 13)
	public void inValidUpdateBookName_Image() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage updateBook = PageFactory.initElements(driver, EmployeePage.class);
		updateBook.updateBook("", "120", "");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 14)
	public void inValidUpdateBookPrice_Image() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage updateBook = PageFactory.initElements(driver, EmployeePage.class);
		updateBook.updateBook("Harry Potter", "", "");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 15)
	public void inValidUpdateBookName_Price_Image() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmployeePage updateBook = PageFactory.initElements(driver, EmployeePage.class);
		updateBook.updateBook("", "", "");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage, message);
	};
	
	@Test(priority = 16)
	public void validUpdateBook() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File srcObject = new File("C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\Object_Repo.properties");
		 
		// Create  FileInputStream object
		FileInputStream fisObject = new FileInputStream(srcObject);
		 
		// Create Properties class object to read properties file
		Properties pro = new Properties();
		 
		// Load file so we can use into our script
		pro.load(fisObject);
		
		EmployeePage updateBook = PageFactory.initElements(driver, EmployeePage.class);
		updateBook.updateBook("Harry Potter", "220", "C:\\Users\\DELL\\OneDrive\\Hình ảnh\\Cuộn phim\\monster.jpg");
		String name = driver.findElement(By.xpath(pro.getProperty("checkBookName"))).getText();
		String price = driver.findElement(By.xpath(pro.getProperty("checkBookPrice"))).getText();
		Assert.assertEquals(name, "Harry Potter");
		Assert.assertEquals(price, "220");
	};
	
	@Test(priority = 17)
	public void toggleBook() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String status = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div/table/tbody/tr[2]/td[6]")).getText();
		System.out.println("Book status before: " + status);
		EmployeePage toggleBook = PageFactory.initElements(driver, EmployeePage.class);
		toggleBook.toggleBook();
	};
	
}
