package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.HomePage;

public class LoginTest extends BaseTest {

	private LoginPage lp;
	private String username = "johndoe19";
	private String password = "supersecret";

	@BeforeMethod
	public void navigateToLogin() {
		driver.get("http://localhost:3100/login");
		lp = new LoginPage(driver);
	}

	@Test
	public void loginSuccess() {
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSignIn();
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.getWelcomeMessage().contains(username));
	}

	@Test
	public void loginFailureInvalidUsername() {
		lp.setUsername("johndoe20");
		lp.setPassword(password);
		lp.clickSignIn();
		Assert.assertEquals(lp.getErrorMessage(), "WRONG CREDENTIALS");
	}

	@Test
	public void loginFailureInvalidPassword() {
		lp.setUsername(username);
		lp.setPassword("secretsuper");
		lp.clickSignIn();
		Assert.assertEquals(lp.getErrorMessage(), "WRONG CREDENTIALS");
	}

	// FIELDS CAN NOT BE EMPTY
	@Test
	public void loginFailureEmptyCredentials() {
		lp.clickSignIn();
		Assert.assertEquals(lp.getErrorMessage(), "FIELDS CAN NOT BE EMPTY");
	}
}
