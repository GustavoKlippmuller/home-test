package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.SearchPage;

public class SearchTest extends BaseTest {
	
	private SearchPage sp;

	@BeforeMethod
	public void navigateToLogin() {
		driver.get("http://localhost:3100/search");
		sp = new SearchPage(driver);
	}
	
	@Test
	public void checkSearchSuccess() {
		String word = "automation";
		sp.setSearchWord(word);
		sp.clickOnButton();
		Assert.assertTrue(sp.getResult().contains(word));
	}
	
	@Test
	public void checkSearchEmpty() {
		sp.clickOnButton();
		Assert.assertTrue(sp.getResult().contains("Please provide a search word."));
	}
	
}
