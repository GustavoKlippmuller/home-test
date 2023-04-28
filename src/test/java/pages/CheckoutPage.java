package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

	@FindBy(id = "fname")
	private WebElement fullName;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "adr")
	private WebElement address;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "state")
	private WebElement state;

	@FindBy(id = "zip")
	private WebElement zipCode;

	@FindBy(id = "cname")
	private WebElement cardName;

	@FindBy(id = "ccnum")
	private WebElement creditCardNumber;

	@FindBy(id = "expmonth")
	private WebElement expirationMonth;

	@FindBy(id = "expyear")
	private WebElement expirationYear;

	@FindBy(id = "cvv")
	private WebElement cvv;

	@FindBy(name = "sameadr")
	private WebElement shippingAddress;

	@FindBy(className = "btn")
	private WebElement checkout;

	@FindBy(xpath = "//p/span[not(contains(@style,'color:black'))]")
	private List<WebElement> prices;

	@FindBy(xpath = "//p/span[contains(@style,'color:black')]")
	private WebElement total;

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void setFullName(String fullname) {
		this.fullName.sendKeys(fullname);
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void setAddress(String address) {
		this.address.sendKeys(address);
	}

	public void setCity(String city) {
		this.city.sendKeys(city);
	}

	public void setState(String state) {
		this.state.sendKeys(state);
	}

	public void setZipCode(String zipCode) {
		this.zipCode.sendKeys(zipCode);
	}

	public void setCardName(String cardName) {
		this.cardName.sendKeys(cardName);
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber.sendKeys(creditCardNumber);
	}

	public void setExpirationMonth(String expirationMonth) {
		Select drop = new Select(this.expirationMonth);
		drop.selectByVisibleText(expirationMonth);
	}

	public void setExpirationYear(String expirationYear) {
		this.expirationYear.sendKeys(expirationYear);
	}

	public void setCvv(String cvv) {
		this.cvv.sendKeys(cvv);
	}

	public void uncheckShippingAddress() {
		if (this.shippingAddress.isSelected())
			this.shippingAddress.click();
	}

	public void checkShippingAddress() {
		if (!this.shippingAddress.isSelected())
			this.shippingAddress.click();
	}

	public void clickCheckout() {
		this.checkout.click();
	}

	public Boolean checkAlertIsPresent() {
		try {
			Alert alert = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.alertIsPresent());
			if (alert == null)
				throw new Throwable();
			else
				return true;
		} catch (Throwable e) {
			return false;
		}
	}

	public void closeAlert() {
		Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

	public List<String> getPrices() {
		List<String> listPrices = new ArrayList<String>();
		for (WebElement price : this.prices)
			listPrices.add(price.getText().replace("$", ""));
		return listPrices;
	}

	public String getTotal() {
		return total.getText().replace("$", "");
	}

}
