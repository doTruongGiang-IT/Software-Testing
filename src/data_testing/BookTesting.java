package data_testing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import base_class.BaseClass;
import page_factory.EmployeePage;
import page_factory.LoginPage;

public class BookTesting extends BaseClass {

	@Test(priority = 1)
	public void addBook() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage empLogin = PageFactory.initElements(driver, LoginPage.class);
		empLogin.login("nhanvien@gmail.com", "123");
		
		EmployeePage addBook = PageFactory.initElements(driver, EmployeePage.class);
		addBook.addBook();
	};
	
//	@Test(priority = 6)
//	public void updateBook() throws Exception {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		EmployeePage updateBook = PageFactory.initElements(driver, EmployeePage.class);
//		updateBook.updateBook();
//	};
//	
//	@Test(priority = 7)
//	public void toggleBook() throws Exception {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		EmployeePage toggleBook = PageFactory.initElements(driver, EmployeePage.class);
//		toggleBook.toggleBook();
//	};
	
}
