import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public abstract class AbstractTest {

	protected EBrowser browser = EBrowser.chrome;// chrome par défaut
	protected WebDriver driver;
	protected String login = "ACID";
	protected String passwd = "ACID";

	public void selectBrowser(EBrowser i) {
		if (i.equals(EBrowser.chrome)) {
			// chemin du driver
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			// Initialisation du navigateur Chrome
			driver = new ChromeDriver();

		} else if (i.equals(EBrowser.firefox)) {
			// chemin du driver
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			// Initialisation du navigateur Chrome
			driver = new FirefoxDriver();

		} else if (i.equals(EBrowser.edge)) {
			// chemin du driver
			System.setProperty("webdriver.edge.driver", "src/main/resources/driver/msedgedriver.exe");
			// Initialisation du navigateur Chrome
			driver = new EdgeDriver();
		}
	}
}
