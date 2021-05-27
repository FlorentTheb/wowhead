import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pages.PageElement;
import pages.PageIndex;
import pages.PageItem;
import pages.PageResultSearch;

public class searchInfoTest extends AbstractTest {

	private String elementSearched = "lardeur";
	private String itemName = "Chahuteurs de cadavre";
	private int itemIndex = 3;

	/* ----------- Items Stats ------------ */
	private String[] item1 = { "Chahuteurs de cadavre", "Niveau d'objet 57", "Lié quand ramassé", "Pieds Tissu",
			"Armure : 2", "+12 Intelligence", "+18 Endurance",
			"Augmente votre score de hâte de +13 (0.39% au niveau 70)", "+11 Versatilité (0.28% au niveau 70)",
			"Durabilité 60 / 60" };
	private String[] item2 = { "Chausses de Lardeur", "Niveau d'objet 57", "Lié quand ramassé", "Jambes Cuir",
			"Armure : 6", "+16 [Agilité or Intelligence]", "+24 Endurance",
			"Augmente votre score de coup critique de +21 (0.60% au niveau 70)", "+12 Versatilité (0.30% au niveau 70)",
			"Durabilité 95 / 95" };
	private String[] item3 = { "Pioche en fer froid", "Niveau d'objet 57", "Lié quand ramassé", "Deux mains Hache",
			"Dégâts : 4 - 10 Vitesse 3.60", "(12.1 dégâts par seconde)", "+16 Force", "+24 Endurance",
			"Augmente votre score de coup critique de +13 (0.37% au niveau 70)",
			"Augmente votre score de hâte de +19 (0.58% au niveau 70)", "Durabilité 90 / 90" };
	private String[] item4 = { "Grèves de geôlier volées", "Niveau d'objet 57", "Lié quand ramassé", "Jambes Mailles",
			"Armure : 8", "+16 [Agilité or Intelligence]", "+24 Endurance",
			"Augmente votre score de coup critique de +20 (0.57% au niveau 70)",
			"Augmente votre score de hâte de +12 (0.36% au niveau 70)", "Durabilité 95 / 95" };
	private String[] item5 = { "Espauliers de Tourne-Clé", "Niveau d'objet 57", "Lié quand ramassé", "Épaule Plaques",
			"Armure : 10", "+12 [Force or Intelligence]", "+18 Endurance",
			"Augmente votre score de coup critique de +9 (0.26% au niveau 70)", "+15 Versatilité (0.38% au niveau 70)",
			"Durabilité 80 / 80" };
	/* ----------- Items Stats ------------ */

	@Before
	public void setup() {
		selectBrowser(browser);
	}

	@Test
	public void test() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://fr.wowhead.com/");
		driver.manage().window().maximize();

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
		// Click sur l'item
		PageItem pageItem;
		pageElement.setNumberItems();
		String[] listToCompare = item1;
		for (int i = 1; i <= pageElement.getNumberItems(); i++) {
			switch (i) {
			case 1:
				listToCompare = item1;
				break;
			case 2:
				listToCompare = item2;
				break;
			case 3:
				listToCompare = item3;
				break;
			case 4:
				listToCompare = item4;
				break;
			case 5:
				listToCompare = item5;
				break;
			}
			System.out.println("Analyse de l'item " + i + "...");
			pageItem = pageElement.clickOnItem(driver, i);
			pageItem.setList();
			compareList(pageItem.getListStats(), listToCompare);
			driver.navigate().back();
			Thread.sleep(4000);
		}
		/* ------------ Page de l'element ----------------- */

	}

	public void compareList(String[] list1, String[] list2) {
		int check = 0;
		assertEquals(list1.length, list2.length);

		for (int i = 0; i < list1.length; i++) {
			assertEquals("the stat is wrong", list1[i], list2[i]);
		}

	}
}
