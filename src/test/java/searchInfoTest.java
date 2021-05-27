import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pages.PageElement;
import pages.PageIndex;
import pages.PageResultSearch;

public class searchInfoTest extends AbstractTest{
	
	private String elementSearched = "lardeur";
	private String itemName = "Chahuteurs de cadavre";
	private int itemIndex = 3;
	
	@Before
	public void setup() {
		selectBrowser(browser);
	}
	
	@Test
	public void test() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://fr.wowhead.com/");
		
		/* ------------ Page d'accueil ----------------- */
		PageIndex pageIndex = PageFactory.initElements(driver, PageIndex.class);
		
		// Accept cookies and decline notifications
		pageIndex.clickOnAcceptCookiesButton();
		pageIndex.clickOnDeclineNotificationsButton();
		// Search lardeur in the search bar
		PageResultSearch pageResult = pageIndex.searchElement(driver, elementSearched);
		/* ------------ Page d'accueil ----------------- */

		
		/* ------------ Page de resultats ----------------- */
		// Click sur le boss lardeur
		PageElement pageElement = pageResult.clickOnElement(driver);
		/* ------------ Page de resultats ----------------- */

		
		/* ------------ Page de l'element ----------------- */
		pageElement.clickOnItem(driver, itemIndex);
		/* ------------ Page de l'element ----------------- */
		
	}
}
