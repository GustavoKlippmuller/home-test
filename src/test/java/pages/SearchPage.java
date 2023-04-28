package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
	
	@FindBy(name="searchWord")
	private WebElement search;
	
	@FindBy(tagName="button")
	private WebElement button;
	
	@FindBy(id="result")
	private WebElement result;

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public void setSearchWord(String word) {
		search.sendKeys(word);
	}
	
	public void clickOnButton() {
		button.click();
	}
	
	public String getResult() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(result, "searching...")));
		return result.getText();
	}

	
	//searching...
}
