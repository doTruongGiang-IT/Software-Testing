package page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage {

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/a[1]/div")
	@CacheLookup
	WebElement order_button;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/a[2]/div")
	@CacheLookup
	WebElement categories_button;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[2]/button")
	@CacheLookup
	WebElement addCategories_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"datatable\"]/tbody/tr[1]/td[4]/button[1]")
	@CacheLookup
	WebElement updateCategories_button;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/a[4]/div")
	@CacheLookup
	WebElement book_button;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/a[5]/div")
	@CacheLookup
	WebElement addBook_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"datatable\"]/tbody/tr[6]/td[5]/button")
	@CacheLookup
	WebElement orderStatus;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"datatable\"]/tbody/tr[6]/td[5]")
	@CacheLookup
	WebElement orderStatusFinish;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"wrapper\"]/div[2]/div/div/div/form/div/table/tbody/tr[2]/td[3]/p")
	@CacheLookup
	WebElement orderStatusCus;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/a[6]/div")
	@CacheLookup
	WebElement logout_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"AddModal\"]/div/div/div[2]/form/input[1]")
	@CacheLookup
	WebElement categoryID;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"AddModal\"]/div/div/div[2]/form/input[2]")
	@CacheLookup
	WebElement categoryName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"AddModal\"]/div/div/div[3]/button[2]")
	@CacheLookup
	WebElement save_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"EditModal1\"]/div/div/div[2]/form/input[3]")
	@CacheLookup
	WebElement editCategoryName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"EditModal1\"]/div/div/div[3]/button[2]")
	@CacheLookup
	WebElement editSave_button;
	
//	@FindBy(how = How.XPATH, using = "//*[@id=\"datatable\"]/tbody/tr[1]/td[2]")
//	@CacheLookup
//	WebElement tableCategoryName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"datatable\"]/tbody/tr[1]/td[4]/button[2]")
	@CacheLookup
	WebElement toggleStatusCategory;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"datatable\"]/tbody/tr[1]/td[3]")
	@CacheLookup
	WebElement statusCategory;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div/table/tbody/tr[2]/td[7]/a/span/img")
	@CacheLookup
	WebElement updateBook;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"price\"]")
	@CacheLookup
	WebElement updatePrice;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/div/form/div[7]/div/p/button")
	@CacheLookup
	WebElement updateBook_button;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div/table/tbody/tr[2]/td[7]/form/button")
	@CacheLookup
	WebElement toggleBook_button;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div/table/tbody/tr[2]/td[6]")
	@CacheLookup
	WebElement toggleBookStatus;
	
	@FindBy(how = How.ID, using = "name")
	@CacheLookup
	WebElement productName;
	
	@FindBy(how = How.ID, using = "price")
	@CacheLookup
	WebElement productPrice;
	
	@FindBy(how = How.ID, using = "description")
	@CacheLookup
	WebElement productDescription;
	
	@FindBy(how = How.ID, using = "cat_id")
	@CacheLookup
	WebElement productCategory;
	
	@FindBy(how = How.ID, using = "image")
	@CacheLookup
	WebElement productUploadImage;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/div/form/div[7]/div/p/button")
	@CacheLookup
	WebElement addNew_button;
	
	public void changeOrderStatus() throws Exception {
		Thread.sleep(1000);
		String expected = "Đã hoàn thành";
		order_button.click();
		Thread.sleep(1000);
		if(orderStatusFinish.getText().contains(expected)) {
			logout_button.click();
		}else {
			orderStatus.click();
			logout_button.click();
		};
	};
	
	public void checkOrderStatus() throws Exception {
		String expected = "Đã hoàn thành";
		Assert.assertEquals(orderStatusCus.getText(), expected);
		System.out.println("Order status: " + orderStatusCus.getText());
		Thread.sleep(2000);
	};
	
	public void addCategory(String id, String name) throws Exception {
		Thread.sleep(1000);
		addCategories_button.click();
		categoryID.sendKeys(id);
		categoryName.sendKeys(name);
		save_button.click();
	};
	
	public void manageCategory(String id, String name) throws Exception {
		Thread.sleep(1000);
		categories_button.click();
		addCategory(id, name);
	};
	
	public void updateCategory(String name) throws Exception {
		Thread.sleep(1000);
		updateCategories_button.click();
		editCategoryName.clear();
		editCategoryName.sendKeys(name);
		editSave_button.click();
	};
	
	public void changeStatusCategory(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.elementToBeClickable(toggleStatusCategory)).click();
		Thread.sleep(1000);
		String statusAfter = statusCategory.getText();
		if(statusAfter.contains("0")) {
			System.out.println("Category status after: Hiển thị");
		}else {
			System.out.println("Category status after: Ẩn");
		};
	};
	
	public void addBook(String name, String price, String description, String cate, String path) throws Exception {
		Thread.sleep(1000);
		addBook_button.click();
		productName.sendKeys(name);
		productPrice.sendKeys(price);
		productDescription.sendKeys(description);
		Select category = new Select(productCategory);
		Thread.sleep(1000);
		category.selectByValue(cate);
		if(path != "") {
			productUploadImage.sendKeys(path);
		};
		addNew_button.click();
	};
	
	public void updateBook(String name, String price, String path) throws Exception {
		Thread.sleep(1000);
		updateBook.click();
		Thread.sleep(1000);
		productName.clear();
		productName.sendKeys(name);
		productPrice.clear();
		productPrice.sendKeys(price);
		if(path != "") {
			productUploadImage.sendKeys(path);
		}
		updateBook_button.click();
	};
	
	public void toggleBook() throws Exception {
		Thread.sleep(1000);
		toggleBook_button.click();
		System.out.println("Book status after: " + toggleBookStatus.getText());
	};
	
}
