package studentPerspective;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModels.LoginPage;
import pageObjectModels.MyBookshelfPage;

public class AddLinkToBookshelf {
	
	private WebDriver driver;
	private final String loginURL = "https://my.otus.com/login";
	private final String myBookshelfURL = "https://my.otus.com/bookshelf/my-bookshelf";

	private LoginPage loginPage;
	private MyBookshelfPage myBookshelfPage;
	
	@Test
	public void addLink() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(loginURL);
		driver.manage().window().maximize();
		
		//Login
		loginPage = new LoginPage(driver);
		//Test Account Credentials
		loginPage.login(email, password);
				
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlContains("home"));
		
		driver.get(myBookshelfURL);
		myBookshelfPage = new MyBookshelfPage(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"outerWrapper\"]/otus-app/ot-theme-provider/main/div/div/ng-component/my-bookshelf/div[1]/div/div[1]/div[2]/button")));
		myBookshelfPage.clickPlus();
		myBookshelfPage.clickResourceButton();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/div/div[2]")));
		myBookshelfPage.clickLinkButton();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/ot-attach-link/div/div[1]/div/input")));
		myBookshelfPage.typeLinkInput("youtube.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/ot-attach-link/div/div[2]/div[2]/input")));
		myBookshelfPage.typeLinkNameInput("Test Link");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/ot-attach-link/div/otus-button/button")));
		myBookshelfPage.clickSaveLink();
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
		
		Assert.assertEquals(myBookshelfPage.checkFirstBookshelfItem(), true);
		
		//myBookshelfPage.deleteFirstBookshelfItem();
		driver.quit();
	}
}
