package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="signin-button")
	private WebElement signIn;
	
	@FindBy(id="message")
	private WebElement errorMessage;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void setUsername(String _username) { username.sendKeys(_username); }
	
	public void setPassword(String _password) { password.sendKeys(_password); }
	
	public void clickSignIn() { signIn.click(); }
	
	public String getErrorMessage() { return errorMessage.getText(); }
	
	

}
