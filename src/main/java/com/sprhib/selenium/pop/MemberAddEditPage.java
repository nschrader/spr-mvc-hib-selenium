package com.sprhib.selenium.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class MemberAddEditPage extends Navbar {

	@FindBy(id="name")
	private WebElement name;
	
	@FindBy(id="teams")
	private WebElement teams;
	
	@FindBy(css="input[type='submit']")
	private WebElement submit;

	public MemberAddEditPage(WebDriver driver) {
		super(driver);
	}
	
	public void typeName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	public void setTeam(Integer id) {
		if (id != null)
			teams.findElements(By.tagName("option")).get(id).click();
	}
	
	public void submitForm() {
		submit.click();
	}
	
}
 
