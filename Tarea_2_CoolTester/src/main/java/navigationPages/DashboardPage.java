package navigationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//DashboardObjects
	@FindBy(id="menu_directory_viewDirectory")
	private WebElement idDirectory;

	
	
	public void SelectMenu() throws InterruptedException {
		//aca colocaria el wait
		Thread.sleep(1000);
		idDirectory.click();
		Thread.sleep(1000);
		
	}

}
