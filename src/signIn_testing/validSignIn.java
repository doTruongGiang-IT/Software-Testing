package signIn_testing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import base_class.BaseClass;
import page_factory.LoginPage;
import page_factory.SigninPage;

public class ValidSignIn extends BaseClass {
	
	@Test(description="This TC will perform valid signin")
	public void validSignin() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int a = ((int) (Math.random()*(10000 - 1000))) + 1000;
		String email = "dotruonggiang" + a + "@gmail.com";
		SigninPage validSignIn = PageFactory.initElements(driver, SigninPage.class);
		validSignIn.signInApp("giangdo", email, String.valueOf(a));
		driver.switchTo().alert().accept();
		LoginPage validLogin = PageFactory.initElements(driver, LoginPage.class);
		validLogin.loginAfterSignIn(email, String.valueOf(a));
	};
	
}
