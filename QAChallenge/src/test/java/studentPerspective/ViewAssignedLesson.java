package studentPerspective;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModels.LessonPage;
import pageObjectModels.LoginPage;
import pageObjectModels.QATechChallengeLessonPage;

public class ViewAssignedLesson {

	private WebDriver driver;
	private final String loginURL = "https://my.otus.com/login";
	private final String lessonURL = "https://my.otus.com/lesson";
	private LoginPage loginPage;
	private LessonPage lessonPage;
	private QATechChallengeLessonPage qaTechChallengeLessonPage;
	
	//I moved the waits into the POMs. Easier to read tests
	@Test
	public void viewLesson() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(loginURL);
		driver.manage().window().maximize();
		
		//Login
		loginPage = new LoginPage(driver);
		
		//Test Account Credentials
		loginPage.login("jacobaerwin@gmail.com", "P90m9a11!!");
		
		//View Lesson
		driver.get(lessonURL);
		lessonPage = new LessonPage(driver);
		lessonPage.clickFirstLesson();
		
		//View First Link
		qaTechChallengeLessonPage = new QATechChallengeLessonPage(driver);
		qaTechChallengeLessonPage.clickFirstLink();
		Assert.assertEquals(qaTechChallengeLessonPage.isDownloadPresent(), true);
		driver.quit();
		
	}
}
