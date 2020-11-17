package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LessonPage {

	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/ng-component/otus-lesson-list-student/div/div/div[2]/table/tbody/tr")
	WebElement firstLesson;
	
	public WebDriver driver;
	public WebDriverWait wait;
	public LessonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
	}
	
	public void clickFirstLesson() {
		wait.until(ExpectedConditions.elementToBeClickable(firstLesson));
		this.firstLesson.click();
	}
	
}
