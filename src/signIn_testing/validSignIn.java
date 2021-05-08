package signIn_testing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import base_class.BaseClass;
import page_factory.PageFac;

public class ValidSignIn extends BaseClass {
	
	@Test(description="This TC will perform valid login")
	public void validSignin() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int a = ((int) (Math.random()*(10000 - 1000))) + 1000;
		String email = "dotruonggiang" + a + "@gmail.com";
		PageFac validSignIn = PageFactory.initElements(driver, PageFac.class);
		validSignIn.signInApp("giangdo", email, String.valueOf(a));
		driver.switchTo().alert().accept();
		validSignIn.loginAfterSignIn(email, String.valueOf(a));
	};
	
}
