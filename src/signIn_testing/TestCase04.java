package signIn_testing;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase04 {
	String url = "https://shopee.vn/";
	WebDriver driver;
	
	@BeforeTest
	public void testPrepare() {
		String ChromeDriver = new File("").getAbsolutePath() +"\\chromedriver.exe";
		System.setProperty("Webdriver.chrome.driver",ChromeDriver);
		driver = new ChromeDriver();
		driver.get(url);
	};
	
	@Test
	public void signInWithFacebookWithWrongPassword() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[2]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div/div[1]/div/ul/a[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Click "login with Facebook" button
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/form/div/div[2]/div[3]/div[2]/button[1]")).click();
		Thread.sleep(2000);
		
		// Get multi id windows
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		// Switch to the new window (sign-in form)
		driver.switchTo().window(childWindow);
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("0776134908");
		
		WebElement password = driver.findElement(By.id("pass"));
		password.clear();
		password.sendKeys("baocaodoan");
		driver.findElement(By.id("loginbutton")).click();
		
		String expected = "Vui lòng nhập lại mật khẩu của bạn";
		String alert = driver.findElement(By.xpath("//*[@id=\"error_box\"]/div[1]")).getText();
		Assert.assertEquals(alert, expected);
		driver.close();
		
		// Switch back to the main window
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		driver.quit();
	};
}
