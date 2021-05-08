package signIn_testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import base_class.BaseClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import page_factory.PageFac;

public class InValidSignIn extends BaseClass {
	
	@Test(description="This TC will perform invalid login")
	public void invalidSignIn() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expected = "Đăng ký thất bại";
		PageFac invalidSignIn = PageFactory.initElements(driver, PageFac.class);
		invalidSignIn.signInApp("giangdo", "dotruonggiang@gmail.com", "123456789");
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertText, expected);
	};

}
