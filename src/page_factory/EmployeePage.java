package page_factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

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
	
	public void addCategory() throws Exception {
		Thread.sleep(1000);
		int id = ((int) (Math.random()*(100 - 10))) + 10;
		categories_button.click();
		Thread.sleep(1000);
		addCategories_button.click();
		categoryID.sendKeys(String.valueOf(id));
		categoryName.sendKeys("Book of thiefs");
		save_button.click();
	};
	
	public void updateCategory() throws Exception {
		Thread.sleep(1000);
		updateCategories_button.click();
		editCategoryName.sendKeys("Sách Kỹ Thuật Lập Trình Nâng Cao");
		editSave_button.click();
	};
	
	public void changeStatusCategory() throws Exception {
		Thread.sleep(1000);
		String expected = "1";
		toggleStatusCategory.click();
		Thread.sleep(1000);
		Assert.assertEquals(statusCategory.getText(), expected);
	};
	
	public void addBook() throws Exception {
		Thread.sleep(1000);
		addBook_button.click();
		productName.sendKeys("Sách gián điệp mạng nâng cao");
		productPrice.sendKeys("100");
		productDescription.sendKeys("Cuốn sách là câu chuyện người thực việc thực (tác giả cũng là nhân vật chính) kể về cuộc săn đuổi hacker bất đắc dĩ của một nhà khoa học chuyển tay ngang trở thành nhà quản lý hệ thống mạng máy tính ở Phòng Thí nghiệm  Lawrence Berkeley, California, Mỹ.");
		Select category = new Select(productCategory);
		Thread.sleep(1000);
		category.selectByValue("5");
		addNew_button.click();
	};
	
	public void updateBook() throws Exception {
		Thread.sleep(1000);
		book_button.click();
		updateBook.click();
		Thread.sleep(1000);
		updatePrice.clear();
		updatePrice.sendKeys("120");
		updateBook_button.click();
	};
	
	public void toggleBook() throws Exception {
		Thread.sleep(1000);
		String status = "Hiển thị";
		toggleBook_button.click();
		Assert.assertEquals(toggleBookStatus.getText(), status);
	};
	
}