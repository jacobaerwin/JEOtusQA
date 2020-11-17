package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechChallengeAssessmentPage {

	@FindBy(xpath="/html/body/div/otus-app/ot-theme-provider/main/div/div/ng-component/section/student-simple-assess/div/div[1]/div[2]/div/div/student-simple-assess-short-answer/div/div/otus-text-area/div/textarea")
	WebElement answerInput;
	
	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/student-simple-assess/div/div[2]/div[1]/div")
	WebElement pencilSaveButton;
	
	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/student-simple-assess/div/div[2]/div[2]/otus-button[1]/button")
	WebElement saveAndExitButton;
	
	@FindBy(xpath="/html/body/div[2]/div/div[3]/otus-button[1]/button")
	WebElement saveAndExitYes;
	
	@FindBy(xpath="/html/body/div/otus-app/ot-theme-provider/main/div/div/ng-component/section/student-simple-assess/div/div[1]/div[2]/div/div/student-simple-assess-short-answer/div/div/otus-text-area/div/textarea")
	WebElement textInput;
	
	public WebDriver driver;
	public TechChallengeAssessmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void inputText(String text) {
		this.answerInput.sendKeys(text);
	}
	
	public void clearText() {
		this.answerInput.clear();
	}
	
	public void clickPencilSave() {
		this.pencilSaveButton.click();
	}
	
	public void clickSaveAndExit() {
		this.saveAndExitButton.click();
	}
	
	public void clickYesModalSave() {
		this.saveAndExitYes.click();
	}
	
	public String getTextInput() {
		return this.answerInput.getText();
	}
	
	//Determines if the text area is clean
	public String getTextAreaStatus() {
		return this.textInput.getAttribute("value");
	}
}
