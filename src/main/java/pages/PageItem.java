package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageItem {

	@FindBy(xpath = "//*[@class='heading-size-1']")
	private WebElement itemTitle;

	@FindBy(xpath = "//*[@class='heading-size-1']/following-sibling::div/table/tbody/tr[1]/td/table[1]/tbody/tr/td")
	private WebElement statsTable;
	
	private int numberStats;
	private String[] statsList;
	
	public String getItemTitle() {
		return itemTitle.getText();
	}
	
	public void setList() {
		statsList = statsTable.getText().split("\n");
		numberStats = statsList.length;
	}
	
	public int getNumberStats() {
		return numberStats;
	}
	
	public String[] getListStats() {
		return statsList;
	}
	
	public void displayText() {
		System.out.println("Stats :");
		for(int i=0; i<numberStats; i++) {
			System.out.println(statsList[i]);
		}
	}
}
