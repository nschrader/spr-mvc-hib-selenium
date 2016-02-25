package com.sprhib.selenium.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamAddEditPage extends Navbar {

	@FindBy(id="name")
	private WebElement name;
	
	@FindBy(id="rating")
	private WebElement rating;
	
	@FindBy(css="input[type='submit']")
	private WebElement submit;

	public TeamAddEditPage(WebDriver driver) {
		super(driver);
	}
	
	public void typeName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	public void typeRating(Integer rating) {
		this.rating.clear();
		if (rating != null)
			this.rating.sendKeys(rating.toString());
		else
			this.rating.sendKeys("");
	}
	
	public void submitForm() {
		submit.click();
	}
	
}
 
