package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import models.Item;

public class GridPage extends BasePage {
	
	@FindBy(xpath="//h4[@data-test-id=\"item-name\"]")
	List<WebElement> listItems;

	@FindBy(id="item-price")
	List<WebElement> listPrices;
	
	@FindBy(className="item")
	List<WebElement> items;

	public GridPage(WebDriver driver) {
		super(driver);
	}
	
	public List<String> getListItems(){
		List<String> listOfItems = new ArrayList<String>();
		for(WebElement item : this.listItems) {
			listOfItems.add(item.getText());
		}
		return listOfItems;
	}

	public List<String> getListPrices(){
		List<String> listOfPrices = new ArrayList<String>();
		for(WebElement price : this.listPrices) {
			listOfPrices.add(price.getText());
		}
		return listOfPrices;
	}
	
	public List<Item> getListTitles() {
		
		List<Item> listItems = new ArrayList<Item>();
	
		for(WebElement item : this.items) {
			
			try {

			listItems.add(new Item(
					item.findElement(By.tagName("img")).getAttribute("src"),
					item.findElement(By.tagName("h4")).getText(),
					item.findElement(By.tagName("p")).getText(),
					item.findElement(By.tagName("button")).getText()));
			} catch (Throwable e) {
				listItems.add(new Item());
			}
		}
		
		return listItems;
		
	}
}
