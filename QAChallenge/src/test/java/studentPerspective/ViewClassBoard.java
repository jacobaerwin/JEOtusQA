package studentPerspective;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModels.LoginPage;
import pageObjectModels.MyClassesPage;
import pageObjectModels.QATechChallengeClassBoardPage;

public class ViewClassBoard {

	private final String classesURL = "https://my.otus.com/classes/my-classes";
	private WebDriver driver;
	private final String loginURL = "https://my.otus.com/login";
	
	private LoginPage loginPage;
	private MyClassesPage myClassesPage;
	private QATechChallengeClassBoardPage qaTechChallengeClassBoardPage;
	
	@Test
	public void viewClassBoard() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(loginURL);
		driver.manage().window().maximize();
		
		//Login
		loginPage = new LoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlContains("login"));
		//Test Account Credentials 
		loginPage.login(email, password);
				
		wait.until(ExpectedConditions.urlContains("home"));
		
		driver.get(classesURL);
		myClassesPage = new MyClassesPage(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/home-course-component/home-student-course-component/div/div[2]/div/ot-class-card")));
		myClassesPage.clickClassCard();
		
		qaTechChallengeClassBoardPage = new QATechChallengeClassBoardPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/ng-component/section/ot-class-board-outlet/ot-class-board/ot-class-board-posts/ot-post-tile")));
		qaTechChallengeClassBoardPage.clickPost();
		
		Assert.assertEquals(driver.getCurrentUrl().substring(driver.getCurrentUrl().length() - 4), "true");
		driver.quit();
	}
}
