package page_factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminPage {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"wn__header\"]/div/div[1]/div[3]/ul/li[3]/a")
	@CacheLookup
	WebElement icon_user;
	
	@FindBy(how = How.XPATH, using= "/html/body/div/div[2]/div[1]/a[1]/div")
	@CacheLookup
	WebElement employee_button;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"datatable\"]/tbody/tr[3]/td[7]/button")
	@CacheLookup
	WebElement lock_button;
	
	@FindBy(how = How.XPATH, using= "/html/body/div[1]/div[2]/div[1]/a[2]/div")
	@CacheLookup
	WebElement adminLogout_button;

	public void lockAccount() throws Exception {
		Thread.sleep(2000);
		employee_button.click();
		lock_button.click();
		adminLogout_button.click();
		Thread.sleep(2000);
	};
	
	public void unLockAccount() throws Exception {
		Thread.sleep(2000);
		employee_button.click();
		lock_button.click();
		adminLogout_button.click();
		Thread.sleep(2000);
	};
	
}
