package signIn_testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import base_class.BaseClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import page_factory.SigninPage;

public class InValidSignIn extends BaseClass {
	
	@Test(priority = 1, description = "This TC will perform invalid login with wrong password")
	public void invalidSigninPassword() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expected = "Đăng ký thất bại";
		SigninPage invalidSignIn = PageFactory.initElements(driver, SigninPage.class);
		invalidSignIn.signInApp("giangdo", "dotruonggiang@gmail.com", "123456789");
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertText, expected);
	};
	
	@Test(priority = 2, description = "This TC will perform invalid login with incorrect email")
	public void invalidSigninEmail() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SigninPage invalidSignIn = PageFactory.initElements(driver, SigninPage.class);
		invalidSignIn.continueSignInApp("giangdo", "dotruonggiang.com", "123456789");
	};
	
	@Test(priority = 3, description = "This TC will perform invalid login with plank username")
	public void invalidSigninUsername() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SigninPage invalidSignIn = PageFactory.initElements(driver, SigninPage.class);
		invalidSignIn.continueSignInApp("", "dotruonggiang999@gmail.com", "123456789");
	};

}
