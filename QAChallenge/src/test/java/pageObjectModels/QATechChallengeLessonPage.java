package pageObjectModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QATechChallengeLessonPage {

	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/student-lesson/div/div/div[3]/lesson-card[1]/ot-card")
	WebElement firstLink;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/ot-student-activity-modal/ot-modal/ot-overlay/ot-modal-body/div/div[3]/button")
	WebElement downloadButton;
}
