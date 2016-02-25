package com.sprhib.selenium.pop;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MemberListPage extends MemberAddEditPage {

	@FindBy(tagName="td")
	private List<WebElement> td;
	
	@FindBy(className="edit")
	private List<WebElement> edit;
	
	@FindBy(className="delete")
	private List<WebElement> delete;

	public MemberListPage(WebDriver driver) {
		super(driver);
	}
	
	public List<String[]> getTableCells() {
		List<String[]> tableCells = new ArrayList<String[]>();
		String[] tmp = new String[3];
		for (int i = 0; i < td.size(); i++) {
			if (i%4 == 3) {
				tableCells.add(tmp);
				tmp = new String[3];
			} else
				tmp[i%4] = td.get(i).getText();
		}
		return tableCells;
	}
	
	public void clickEdit(int id) {
		edit.get(id).click();
	}
	
	public void clickDelete(int id) {
		delete.get(id).click();
	}
}
