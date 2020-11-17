package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessmentPage {

	@FindBy(className="otus-large-table")
	public WebElement table;
	
	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/ng-component/ot-assess-list-student/div/div[2]/table/tbody/tr/span/td[1]")
	public WebElement assessment;
	
	@FindBy(xpath="/html/body/div[2]/div/div[2]/otus-button/button/span")
	public WebElement startModalButton;
	
	public WebDriver driver;
	public AssessmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickFirstAssessment() {
		this.assessment.click();
	}
	
	public void clickStart() {
		this.startModalButton.click();
	}
}
