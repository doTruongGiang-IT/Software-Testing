package data_testing;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import base_class.BaseClass;
import page_factory.PageFac;

public class DataDriven extends BaseClass {

	@Test(priority = 1, description = "This TC will get data from database and export excel file")
	public void getData() {
		PageFac getData = PageFactory.initElements(driver, PageFac.class);
		getData.exportData();
	};
	
	
	
}
