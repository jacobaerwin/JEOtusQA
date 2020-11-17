package pageObjectModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LessonPage {

	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/ng-component/otus-lesson-list-student/div/div/div[2]/table/tbody/tr/td[1]")
	WebElement firstLesson;
	
	
}
