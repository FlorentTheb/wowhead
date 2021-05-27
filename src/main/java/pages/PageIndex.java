package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageIndex {
	
	@FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
	private WebElement acceptCookiesButton;
	
	@FindBy(xpath = "//*[@class='notifications-dialog-buttons-decline btn']")
	private WebElement declineNotificationsButton;
	
	@FindBy(xpath = "//*[@class='header-search']/form/input")
	private WebElement searchInput;
	
	@FindBy(xpath = "//*[@class='header-search-button fa fa-search']")
	private WebElement searchButton;
	
	public void clickOnAcceptCookiesButton() {
		acceptCookiesButton.click();
	}
	
	public void clickOnDeclineNotificationsButton() {
		declineNotificationsButton.click();
	}
	
	public PageResultSearch searchElement(WebDriver driver, String element) {
		searchInput.clear();
		searchInput.sendKeys(element);
		searchButton.click();
		return PageFactory.initElements(driver, PageResultSearch.class);
	}
}
