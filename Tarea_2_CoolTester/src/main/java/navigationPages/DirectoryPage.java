package navigationPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DirectoryPage {
	
	public  DirectoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Directory Objects or WebElements
	@FindBy(id="searchDirectory_emp_name_empName")
	private WebElement nameDirectory;
	
	@FindBy(id="searchDirectory_job_title")
	private WebElement jobTitle;
	
	@FindBy(xpath="//*[@id=\"searchDirectory_location\"]")
	private WebElement locationDirectory;
	
	@FindBy(id="searchBtn")
	private WebElement btnSearchDirectory;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr[2]/td[2]/ul/li[1]/b")
	private WebElement nameDirectoryFind;
	
	public String SearchDirectory(String name, String title, String location) throws InterruptedException {
		nameDirectory.sendKeys(name);
		
		Select TitleSelect = new Select(jobTitle);
    	TitleSelect.selectByVisibleText(title);
    	
    	Select locationSelect = new Select(locationDirectory);
    	locationSelect.selectByVisibleText(location);
    	btnSearchDirectory.click();
    	
    	Thread.sleep(2000);
    	
    	String nameFind = nameDirectoryFind.getText();
    	return nameFind;
	}
	

}
