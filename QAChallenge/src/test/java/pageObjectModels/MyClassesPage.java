package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyClassesPage {

	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/home-course-component/home-student-course-component/div/div[2]/div/ot-class-card")
	WebElement classCard;
	
	public WebDriver driver;
	public MyClassesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickClassCard() {
		this.classCard.click();
	}
	
}
