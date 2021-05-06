package page_factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageFac {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"wn__header\"]/div/div[1]/div[3]/ul/li[3]/a")
	@CacheLookup
	WebElement icon_user;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"wn__header\"]/div/div[1]/div[3]/ul/li[3]/div/div/div/div/div/div/span[3]/a")
	@CacheLookup
	WebElement create_account;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"wn__header\"]/div/div[1]/div[3]/ul/li[3]/div/div/div/div/div/div/span[2]/a")
	@CacheLookup
	WebElement login_account;
	
	@FindBy(how = How.ID, using = "nameInput") 
	@CacheLookup
	WebElement username; 
	 
	@FindBy(how = How.ID, using = "emailInput")
	@CacheLookup
	WebElement email;
	 
	@FindBy(how = How.ID, using = "passwordInput")
	@CacheLookup
	WebElement password;
	 
	@FindBy(how = How.XPATH, using= "//*[@id=\"register-container\"]/div/div[2]/div/form/button")
	@CacheLookup
	WebElement signin_button;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"login-container\"]/div/form/div[1]/div/input")
	@CacheLookup
	WebElement mailLoginAfterSignin;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"login-container\"]/div/form/div[2]/div/input")
	@CacheLookup
	WebElement passLoginAfterSignin;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"login-container\"]/div/form/div[4]/div/button")
	@CacheLookup
	WebElement loginAfterSignin_button;
	 
	public void signInApp(String name, String mail, String pass) {
		icon_user.click();
		create_account.click();
		username.sendKeys(name);
		email.sendKeys(mail);
		password.sendKeys(pass);
		signin_button.click();
	};
	
	public void loginAfterSignIn(String mail, String pass) {
		mailLoginAfterSignin.sendKeys(mail);
		passLoginAfterSignin.sendKeys(pass);
		loginAfterSignin_button.click();
	};
	
	public void login(String mail, String pass) {
		icon_user.click();
		login_account.click();
		loginAfterSignIn(mail, pass);
	};	

}
