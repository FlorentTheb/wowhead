package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageElement {

	@FindBy(xpath = "//*[@class='clickable']")
	private WebElement itemsTable;

	private int numberItems;

	public void setNumberItems() {
		numberItems = (itemsTable.findElements(By.xpath("tr"))).size();
	}

	public int getNumberItems() {
		return numberItems;
	}

	public PageItem clickOnItem(WebDriver driver, String itemName) {
		WebElement choosenItem = itemsTable.findElement(By.xpath("//*[text()='" + itemName + "']"));
		choosenItem.click();
		return PageFactory.initElements(driver, PageItem.class);

	}

	public PageItem clickOnItem(WebDriver driver, int itemIndex) {
		if((itemIndex > numberItems) || (itemIndex < 1)) {
			System.out.println("Wrong index (out of bounds)");
			itemIndex = numberItems;
		}

		WebElement choosenItem = itemsTable.findElement(By.xpath("tr")).findElement(By.xpath("(//*[@class='q3 listview-cleartext'])[" + itemIndex + "]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", choosenItem);
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(choosenItem));
		choosenItem.click();
		return PageFactory.initElements(driver, PageItem.class);
	}
}
