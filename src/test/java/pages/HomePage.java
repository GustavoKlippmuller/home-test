package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(id="welcome-message")
	private WebElement welcomeText;
	
	@FindBy(linkText="Form")
	private WebElement formTab;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getWelcomeMessage() { return welcomeText.getText(); }
	
	public void goToForm() { formTab.click(); }

}
