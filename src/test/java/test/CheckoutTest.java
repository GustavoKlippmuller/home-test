package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.OrderPage;


public class CheckoutTest extends BaseTest {

	private CheckoutPage cp;

	private String fullName = "Juan Martin Del Potro";
	private String email = "juan.delpotro@gmail.com";
	private String address = "San Martin 840";
	private String city = "Buenos Aires";
	private String state = "Buenos Aires";
	private String zipCode = "C1234";
	private String cardName = "Visa";
	private String creditCardNumber = "4321123498760000";
	private String expirationMonth = "June";
	private String expirationYear = "2025";
	private String cvv = "123";
	
	@BeforeMethod
	public void navigateToCheckout() {
		driver.get("http://localhost:3100/checkout");
		cp = new CheckoutPage(driver);
	}
	
	@Test
	public void validCheckoutSuccess() {
		completeForm();
		cp.checkShippingAddress();
		cp.clickCheckout();
		OrderPage op = new OrderPage(driver);
		Assert.assertNotEquals(op.getOrderNumber(), "");
	}
	
	@Test
	public void validCheckoutFormAlert() {
		completeForm();
		cp.uncheckShippingAddress();
		cp.clickCheckout();
		Assert.assertTrue(cp.checkAlertIsPresent());
		cp.closeAlert();
		Assert.assertFalse(cp.checkAlertIsPresent());

	}

	@Test
	public void validCartTotal() {
		Integer totalAmount = 0;
		for(String price : cp.getPrices()) totalAmount += Integer.parseInt(price);
		Assert.assertEquals(totalAmount, Integer.parseInt(cp.getTotal()));
	}

	private void completeForm() {
		cp.setFullName(fullName);
		cp.setEmail(email);
		cp.setAddress(address);
		cp.setCity(city);
		cp.setState(state);
		cp.setZipCode(zipCode);
		cp.setCardName(cardName);
		cp.setCreditCardNumber(creditCardNumber);
		cp.setExpirationMonth(expirationMonth);
		cp.setExpirationYear(expirationYear);
		cp.setCvv(cvv);
	}
}
