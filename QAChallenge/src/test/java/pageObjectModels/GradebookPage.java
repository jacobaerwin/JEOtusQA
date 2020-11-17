package pageObjectModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GradebookPage {

	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ot-student-family-gradebook-container/section/div/ot-student-family-gradebook/div/div[3]/ot-student-gradebook-grid/div/ui-grid-action/div/div/div[1]/ag-grid-angular/div/div[1]/div/div[3]/div[1]/div/div/div")
	WebElement firstGradebookClass;
	
	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ot-student-family-gradebook-container/section/div/ot-student-family-gradebook/div/div[1]/div[3]/div/otus-button-group/button[2]")
	WebElement standardsTab;
	
	
}
