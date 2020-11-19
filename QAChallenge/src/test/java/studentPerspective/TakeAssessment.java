package studentPerspective;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModels.AssessmentPage;
import pageObjectModels.LoginPage;
import pageObjectModels.TechChallengeAssessmentPage;

public class TakeAssessment {

	private WebDriver driver;
	private final String loginURL = "https://my.otus.com/login";
	private final String assessmentURL = "https://my.otus.com/assessment/list";
	private LoginPage loginPage;
	private AssessmentPage assessmentPage;
	private TechChallengeAssessmentPage techChallengeAssessmentPage;
	
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
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		driver.get(assessmentURL);
		
		//Start first assessment
		assessmentPage = new AssessmentPage(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/ng-component/ot-assess-list-student/div/div[2]/table/tbody/tr")));
		assessmentPage.clickFirstAssessment();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/otus-button/button/span")));
		assessmentPage.clickStart();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/otus-app/ot-theme-provider/main/div/div/ng-component/section/student-simple-assess/div/div[1]/div[2]/div/div/student-simple-assess-short-answer/div/div/otus-text-area/div/textarea")));
		
		techChallengeAssessmentPage = new TechChallengeAssessmentPage(driver);
		
		//Clear and input text for testing
		techChallengeAssessmentPage.clearText();
		techChallengeAssessmentPage.inputText("Test text");
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("/html/body/div/otus-app/ot-theme-provider/main/div/div/ng-component/section/student-simple-assess/div/div[1]/div[2]/div/div/student-simple-assess-short-answer/div/div/otus-text-area/div/textarea"), "Test text"));
		techChallengeAssessmentPage.clickPencilSave();
		//Wait for save to occur
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		techChallengeAssessmentPage.clickSaveAndExit();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[3]/otus-button[1]/button")));
		techChallengeAssessmentPage.clickYesModalSave();
		
		//Go back to assessment
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/ng-component/ot-assess-list-student/div/div[2]/table/tbody/tr")));
		assessmentPage.clickFirstAssessment();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/otus-button/button/span")));
		assessmentPage.clickStart();
		
		//Check if text is saved
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/otus-app/ot-theme-provider/main/div/div/ng-component/section/student-simple-assess/div/div[1]/div[2]/div/div/student-simple-assess-short-answer/div/div/otus-text-area/div/textarea")));
		Assert.assertEquals(this.techChallengeAssessmentPage.getTextAreaStatus(), "Test text");
		driver.quit();
		
	}
}
