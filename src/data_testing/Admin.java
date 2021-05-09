package data_testing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import base_class.BaseClass;
import page_factory.AdminPage;
import page_factory.LoginPage;

public class Admin extends BaseClass {

	@Test(priority = 1, description = "This TC will perform locking account")
	public void lockAccount() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage loginAccount = PageFactory.initElements(driver, LoginPage.class);
		loginAccount.login("admin@gmail.com", "admin");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AdminPage lockAccount = PageFactory.initElements(driver, AdminPage.class);
		lockAccount.lockAccount();
	};
	
	@Test(priority = 2, description = "This TC will perform login with locked account")
	public void loginWithLockedAccount() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage loginAccount = PageFactory.initElements(driver, LoginPage.class);
		loginAccount.login("dotruonggiang1018@gmail.com", "1018");
	};
	
	@Test(priority = 3, description = "This TC will perform unlock account above")
	public void unLockAccount() throws Exception {
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		LoginPage loginAccount = PageFactory.initElements(driver, LoginPage.class);
		loginAccount.loginAfterSignIn("admin@gmail.com", "admin");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AdminPage unLockAccount = PageFactory.initElements(driver, AdminPage.class);
		unLockAccount.unLockAccount();
	};
	
	@Test(priority = 4, description = "This TC will perform login with locked account")
	public void loginWithUnlockAccount() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage loginAccount = PageFactory.initElements(driver, LoginPage.class);
		loginAccount.login("dotruonggiang1018@gmail.com", "1018");
	};
	
}
