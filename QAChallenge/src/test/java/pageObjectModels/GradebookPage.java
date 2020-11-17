package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GradebookPage {

	public WebDriver driver;
	public WebDriverWait wait;
	

	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ot-student-family-gradebook-container/section/div/ot-student-family-gradebook/div/div[3]/ot-student-gradebook-grid/div/ui-grid-action/div/div/div[1]/ag-grid-angular/div/div[1]/div/div[3]/div[1]/div/div/div")
	WebElement firstGradebookClass;
	
	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ot-student-family-gradebook-container/section/div/ot-student-family-gradebook/div/div[3]/ot-student-gradebook-grid/div/div/ui-grid-action/div/div/div[1]")
	WebElement classDetailsTable;
	
	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ot-student-family-gradebook-container/section/div/ot-student-family-gradebook/div/div[1]/div[3]/div/otus-button-group/button[2]")
	WebElement standardsTab;
	
	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ot-student-family-gradebook-container/section/div/ot-student-family-gradebook/div/div[2]/student-standards-gradebook/student-standards-gradebook-grid/ui-grid-action/div/div/div/ag-grid-angular/div/div[1]/div")
	WebElement standardsTable;
	
	public GradebookPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
	}
	
	public void clickFirstClass() {
		wait.until(ExpectedConditions.elementToBeClickable(firstGradebookClass));
		this.firstGradebookClass.click();
	}
	
	public boolean areDetailsPresent() {
		wait.until(ExpectedConditions.elementToBeClickable(classDetailsTable));
		return this.classDetailsTable.isDisplayed();
	}
	
	public void clickStandardsTab() {
		wait.until(ExpectedConditions.elementToBeClickable(standardsTab));
		this.standardsTab.click();
	}
	
	public boolean isStandardsDisplayed() {
		wait.until(ExpectedConditions.elementToBeClickable(standardsTable));
		return this.standardsTable.isDisplayed();
	}
	
}
