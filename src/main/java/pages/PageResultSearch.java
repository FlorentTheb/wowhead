package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageResultSearch {

	@FindBy(xpath = "//*[@class='top-results-result-name-box icon-boss-padded']//ancestor::table[@class='top-results-result-table']/following-sibling::a")
	private WebElement lardeurBossLink;
	
	public PageElement clickOnElement(WebDriver driver) {
		lardeurBossLink.click();
		return PageFactory.initElements(driver, PageElement.class);
	}
}
