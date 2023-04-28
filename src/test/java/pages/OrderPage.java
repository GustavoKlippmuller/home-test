package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage {

	@FindBy(xpath="//*[@id='order-confirmation']/p")
	private WebElement orderNumber;
	
	
	public OrderPage(WebDriver driver) {
		super(driver);
	}
	
	public String getOrderNumber() { return orderNumber.getText(); }

}
