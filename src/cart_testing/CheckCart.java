package cart_testing;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import base_class.BaseClass;
import page_factory.CartPage;

public class CheckCart extends BaseClass {

	@Test(priority = 1, description="This TC will check add product to shopping-cart")
	public void addProduct() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File srcObject = new File("C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\Object_Repo.properties");
		 
		// Create  FileInputStream object
		FileInputStream fisObject = new FileInputStream(srcObject);
		 
		// Create Properties class object to read properties file
		Properties pro = new Properties();
		 
		// Load file so we can use into our script
		pro.load(fisObject);
		
		WebElement bookCategories = driver.findElement(By.xpath(pro.getProperty("bookCategories")));
		Actions hover = new Actions(driver);
		hover.moveToElement(bookCategories).perform();
		
		// Add product
		CartPage addItem = PageFactory.initElements(driver, CartPage.class);
		addItem.addProduct();
	};
	
	@Test(priority = 3, description="This TC will check delete product to shopping-cart")
	public void deleteProduct() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Delete product
		CartPage deleteItem = PageFactory.initElements(driver, CartPage.class);
		deleteItem.deleteProduct();
	};
	
	@Test(priority = 2, description="This TC will check total price")
	public void totalPrice() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File srcObject = new File("C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\Object_Repo.properties");
		 
		// Create  FileInputStream object
		FileInputStream fisObject = new FileInputStream(srcObject);
		 
		// Create Properties class object to read properties file
		Properties pro = new Properties();
		 
		// Load file so we can use into our script
		pro.load(fisObject);
		
		WebElement bookCategories = driver.findElement(By.xpath(pro.getProperty("bookCategories")));
		Actions hover = new Actions(driver);
		hover.moveToElement(bookCategories).perform();
		
		// Check total price
		CartPage totalPrice = PageFactory.initElements(driver, CartPage.class);
		totalPrice.checkTotal();
	};
	
}
