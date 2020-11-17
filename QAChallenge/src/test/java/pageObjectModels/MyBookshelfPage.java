package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBookshelfPage {

	@FindBy(xpath="//*[@id=\"outerWrapper\"]/otus-app/ot-theme-provider/main/div/div/ng-component/my-bookshelf/div[1]/div/div[1]/div[2]/button")
	WebElement plusButton;
	
	@FindBy(xpath="//*[@id=\"ot-option-ot-option-8\"]")
	WebElement resourceButton;
	
	@FindBy(xpath="/html/body/div[5]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/div/div[1]/span")
	WebElement uploadFileButton;
	
	@FindBy(xpath="/html/body/div[5]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/ot-attach-file/ot-drag-drop-area/div/ot-attach-file-add/div[2]/otus-button/button")
	WebElement uploadFileBrowse;
	
	@FindBy(xpath="/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/div/div[2]")
	WebElement linkButton;
	
	@FindBy(xpath="/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/ot-attach-link/div/div[1]/div/input")
	WebElement linkInput;
	
	@FindBy(xpath="/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/ot-attach-link/div/div[2]/div[2]/input")
	WebElement linkNameInput;
	
	@FindBy(xpath="/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/ot-attach-link/div/otus-button/button")
	WebElement linkSaveButton;
	
	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/my-bookshelf/div[1]/div/div[2]/ot-list-resources/div/table/tbody/tr")
	WebElement firstBookshelfEntry;
	
	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/my-bookshelf/div[1]/div/div[2]/ot-list-resources/div/table/tbody/tr/td[2]/button")
	WebElement firstEntryOptions;
	
	@FindBy(xpath="/html/body/div[19]/div[3]/div/ot-overlay/ul/li[4]")
	WebElement deleteFirstEntryOption;
	
	@FindBy(xpath="/html/body/div[21]/div/div/div/div[3]/div/button[1]")
	WebElement confirmDeleteButton;
	
	public MyBookshelfPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickPlus() {
		this.plusButton.click();
	}
	
	public void clickResourceButton() {
		this.resourceButton.click();
	}
	
	public void clickLinkButton() {
		this.linkButton.click();
	}
	
	public void typeLinkInput(String string) {
		this.linkInput.sendKeys(string);
	}
	
	public void typeLinkNameInput(String string) {
		this.linkNameInput.sendKeys(string);
	}
	
	public void clickSaveLink() {
		this.linkSaveButton.click();
	}
	
	public boolean checkFirstBookshelfItem() {
		return this.firstBookshelfEntry.isDisplayed();
	}
	
	public void deleteFirstBookshelfItem() {
		this.firstEntryOptions.click();
		this.deleteFirstEntryOption.click();
		this.confirmDeleteButton.click();
	}
}
