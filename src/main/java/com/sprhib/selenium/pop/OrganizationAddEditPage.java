package com.sprhib.selenium.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationAddEditPage extends Navbar {

	@FindBy(id="name")
	private WebElement name;
	
	@FindBy(css="input[type='submit']")
	private WebElement submit;

	public OrganizationAddEditPage(WebDriver driver) {
		super(driver);
	}
	
	public void typeName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	public void submitForm() {
		submit.click();
	}
	
}
 
