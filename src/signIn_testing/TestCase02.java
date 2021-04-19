package signIn_testing;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase02 {
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
	public void signInWithGoogle() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[2]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div/div[1]/div/ul/a[2]")).click();
		Thread.sleep(2000);
		
		// Click "login with Google" button
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/form/div/div[2]/div[3]/div[2]/button[2]/div[2]")).click();
		Thread.sleep(2000);
		
		// Get multi id windows
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		// Switch to the new window (sign-in form)
		driver.switchTo().window(childWindow);
		Thread.sleep(2000);
		WebElement phoneNumber = driver.findElement(By.id("identifierId"));
		phoneNumber.clear();
		phoneNumber.sendKeys("0776134908");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
		
		//Switch back to the main window
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		driver.quit();
	};	
}
