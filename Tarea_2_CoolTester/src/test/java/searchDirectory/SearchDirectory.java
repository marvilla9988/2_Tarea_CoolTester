package searchDirectory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import driverSetup.DriverSetup;
import globalVariables.GlobalVariables;
import navigationPages.DashboardPage;
import navigationPages.DirectoryPage;
import navigationPages.LoginPage;

public class SearchDirectory {
	//Declarar e inicializar un objeto del tipo WebDriver para usarlo en nuestra Test Class
	WebDriver driver = DriverSetup.setupDriver();
	
	//Login PageObject
	LoginPage login = new LoginPage(driver);
	DashboardPage dashboard = new DashboardPage(driver);
	DirectoryPage directory = new DirectoryPage(driver);
	
	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
		driver.manage().window().maximize();
	}
	  @Test
	  public void SearchDirectory() throws InterruptedException {
		//Step 1: Login
		  login.login(GlobalVariables.USER_ADMIN, GlobalVariables.PASSWORD_ADMIN);
		  
		 //Step 2: Seleccionar Menu Directory
		  dashboard.SelectMenu();
		  
		//Step 3: Search Directory
		  String namefind = directory.SearchDirectory(GlobalVariables.NAME_DIRECTORY, GlobalVariables.TITLE_DIRECTORY, GlobalVariables.LOCATION_DIRECTORY);
		  
		//Step 4: Validar nombre del Director
		  Assert.assertEquals(namefind, "Nathan Elliot");
	  }
	  
	  @AfterTest
	  public void closeDriver() {
		  driver.quit();
	  }
	  
	  
}
