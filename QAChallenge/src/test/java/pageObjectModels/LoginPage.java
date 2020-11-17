package pageObjectModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;

	@FindBy(id="otus-input-1")
	public WebElement emailInput;
	
	@FindBy(id="otus-input-3")
	public WebElement passwordInput;
	
	//This element is present after email and password are input
	@FindBy(xpath="/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/div/div[2]/div/login-component/div/div[2]/otus-button[1]/button")
	public WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password) {
		this.emailInput.sendKeys(username);
		this.passwordInput.sendKeys(password);
		this.loginButton.click();
	}
	
	
}
