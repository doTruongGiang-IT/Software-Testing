package base_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	protected WebDriver driver;
	
	@BeforeTest
	public void setupApplication() {
		Reporter.log("=====Browser Session Started=====", true);
        driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/PTUD_Web_2-master/WEB2/");
		Reporter.log("=====Application Started=====", true);
	};

	@AfterTest
	public void closeApplication() {
		driver.quit();
		Reporter.log("=====Browser Session End=====", true);
	};
	
}
