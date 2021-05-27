package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElement {
	
	@FindBy(xpath = "//*[@class='clickable']")
	private WebElement itemsTable;
	
	public PageItem clickOnItem(WebDriver driver, String itemName) {
		WebElement choosenItem = itemsTable.findElement(By.xpath("//*[text()='" + itemName + "']"));
		choosenItem.click();
		return PageFactory.initElements(driver, PageItem.class);
		
	}

	
	public PageItem clickOnItem(WebDriver driver, int itemIndex) {
		int itemsNumber = (itemsTable.findElements(By.xpath("tr"))).size();
		System.out.println("Number of item is " + itemsNumber + "\nIndex is " + itemIndex);
		if((itemIndex > itemsNumber) || (itemIndex < 1)) {
			System.out.println("Wrong index (out of bounds)\nIndex is " + itemIndex);
			itemIndex = itemsNumber;
		}

		WebElement choosenItem = itemsTable.findElement(By.xpath("tr")).findElement(By.xpath("(//*[@class='q3 listview-cleartext'])[" + itemIndex + "]"));
		System.out.println("Elem = " + choosenItem);
		choosenItem.click();
		return PageFactory.initElements(driver, PageItem.class);
	}
}
