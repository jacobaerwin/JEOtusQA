package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Class id = 1677401
public class QATechChallengeClassBoardPage {

	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/ng-component/section/ot-class-board-outlet/ot-class-board/ot-class-board-posts/ot-post-tile")
	WebElement classPost;
	
	public WebDriver driver;
	public QATechChallengeClassBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickPost() {
		this.classPost.click();
	}
	
}
