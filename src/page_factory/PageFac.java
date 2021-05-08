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
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"wn__header\"]/div/div[1]/div[2]/nav/ul/li[3]/div/ul/li[3]/a")
	@CacheLookup
	WebElement algorithmCategory;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"nav-grid\"]/div/div[2]/div[1]/a[2]")
	@CacheLookup
	WebElement algorithmBook;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"wrapper\"]/div[2]/div[1]/div/div[1]/div/div/div[2]/div/div[3]/form/input[1]")
	@CacheLookup
	WebElement amount;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"wrapper\"]/div[2]/div[1]/div/div[1]/div/div/div[2]/div/div[3]/form/div/button")
	@CacheLookup
	WebElement addToCart_button;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"wn__header\"]/div/div[1]/div[3]/ul/li[2]/a")
	@CacheLookup
	WebElement icon_cart;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"wrapper\"]/div[2]/div/div/div/form/div/table/tbody/tr")
	@CacheLookup
	WebElement order;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"wrapper\"]/div[2]/div/div/div/form/div/table/tbody/tr[1]/td[5]/a")
	@CacheLookup
	WebElement detailOrder;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"wrapper\"]/div[2]/div/div[3]/div/div/div/span[2]")
	@CacheLookup
	WebElement total;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"wrapper\"]/div[2]/div/div[1]/div/form/div/table/tbody/tr/td[6]/a")
	@CacheLookup
	WebElement removeItem;//*[@id="wrapper"]/div[2]/div/div/div/form/div/table/tbody/tr/td[4]/a
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"wn__header\"]/div/div[1]/div[2]/nav/ul/li[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement programCategory;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"nav-grid\"]/div/div[3]/div[1]/a[2]")
	@CacheLookup
	WebElement programBook;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\"wrapper\"]/div[2]/div/div[1]/div/form/div/table/tbody/tr/td[2]/a")
	@CacheLookup
	WebElement bookName;
	 
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
	
	public void addProduct() {
		algorithmCategory.click();
		algorithmBook.click();
		amount.clear();
		amount.sendKeys("3");
		addToCart_button.click();
		icon_cart.click();
		detailOrder.click();
		System.out.println("Book name: " + bookName.getText());
		System.out.println("Total price is: " + total.getText());
	};
	
	public void deleteProduct() {
		System.out.println("Delete book: " + bookName.getText());
		removeItem.click();
		System.out.println("Total price after delete is: " + total.getText());
	};
	
	public void checkTotal() {
		programCategory.click();
		programBook.click();
		amount.clear();
		amount.sendKeys("3");
		addToCart_button.click();
		icon_cart.click();
		detailOrder.click();
		System.out.println("Final price is: " + total.getText());
	};

}
