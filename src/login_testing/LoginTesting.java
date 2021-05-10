package login_testing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import base_class.BaseClass;
import page_factory.LoginPage;

public class LoginTesting extends BaseClass {

	@Test(priority = 1, description = "This TC will perform invalid lognin with wrong email")
	public void inValidLoginEmail() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage invalidLoginEmail = PageFactory.initElements(driver, LoginPage.class);
		invalidLoginEmail.login("dotruonggiang", "123456789");
		driver.navigate().refresh();
	};
	
	@Test(priority = 2, description = "This TC will perform invalid lognin with wrong password")
	public void inValidLoginPassword() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage invalidLoginPass = PageFactory.initElements(driver, LoginPage.class);
		invalidLoginPass.loginAfterSignIn("dotruonggiang@gmail.com", "12345");
		driver.switchTo().alert().accept();
	};
	
	@Test(priority = 3, description = "This TC will perform invalid lognin with wrong email and password")
	public void inValidLoginEmail_Password() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage invalidLogin = PageFactory.initElements(driver, LoginPage.class);
		invalidLogin.loginAfterSignIn("dotruonggiang", "12345");
	};
	
	@Test(priority = 4, description = "This TC will perform valid lognin")
	public void validLogin() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage validLogin = PageFactory.initElements(driver, LoginPage.class);
		validLogin.loginAfterSignIn("dotruonggiang@gmail.com", "123456789");
	};
	
}
