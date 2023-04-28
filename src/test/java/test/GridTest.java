package test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import models.Item;
import pages.GridPage;

public class GridTest extends BaseTest {
	
	private GridPage gp;
	
	@BeforeMethod
	public void navigateToGrid() {
		driver.get("http://localhost:3100/grid");
		gp = new GridPage(driver);
	}

	@Test
	public void checkItemSuperPepperoni() {
		
		// Since the subscripts in lists and arrays start at 0 (zero) I choose to change the value of the position to 6 (six) which would be the seventh position of the list
		Assert.assertEquals(gp.getListItems().indexOf("Super Pepperoni"), 6);
		List<String> listPrices = gp.getListPrices();
		Assert.assertEquals(listPrices.get(6), "$10");
	}

	@Test
	public void checkAllItemsCompleted() {
		for(Item item : gp.getListTitles()) Assert.assertTrue(item.getStatus());
	}

}
