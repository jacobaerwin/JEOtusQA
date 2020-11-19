package studentPerspective;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModels.GradebookPage;
import pageObjectModels.LoginPage;

public class ViewGradebook {

	private WebDriver driver;
	private final String loginURL = "https://my.otus.com/login";
	private final String gradebookURL = "https://my.otus.com/gradebook/my";
	private LoginPage loginPage;
	private GradebookPage gradebookPage;
	
	@Test
	public void assess() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(loginURL);
		driver.manage().window().maximize();
		
		//Login
		loginPage = new LoginPage(driver);
		//Test Account Credentials
		loginPage.login("", "");
		
		driver.get(gradebookURL);
		
		//View class details
		gradebookPage = new GradebookPage(driver);
		gradebookPage.clickFirstClass();
		Assert.assertEquals(gradebookPage.areDetailsPresent(), true);
		
		//View Standards
		gradebookPage.clickStandardsTab();
		Assert.assertEquals(gradebookPage.isStandardsDisplayed(), true);
		driver.quit();
		
	}
}
