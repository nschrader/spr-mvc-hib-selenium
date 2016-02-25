package com.sprhib.selenium.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

	protected WebDriver driver; 
	
	@FindBy(tagName="h1")
	private WebElement h1;	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void open(String url) {
		driver.get(url);
	}
	
	public void close() {
		driver.quit();
	}
	
	public void back() {
		driver.navigate().back();
	}
	
	public String getHeader() {
		return h1.getText();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}