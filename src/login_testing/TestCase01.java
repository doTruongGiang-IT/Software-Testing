package login_testing;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase01 {
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
	public void login() {
		
	};
}
