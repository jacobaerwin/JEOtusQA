package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QATechChallengeLessonPage {

	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/student-lesson/div/div/div[3]/lesson-card[1]/ot-card")
	WebElement firstLink;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/ot-student-activity-modal/ot-modal/ot-overlay/ot-modal-body/div/div[3]/button")
	WebElement downloadButton;
	
	public WebDriver driver;
	public WebDriverWait wait;
	public QATechChallengeLessonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
	}
	
	public void clickFirstLink() {
		wait.until(ExpectedConditions.elementToBeClickable(firstLink));
		this.firstLink.click();
	}
	
	public boolean isDownloadPresent() {
		wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
		return this.downloadButton.isDisplayed();
	}
}
