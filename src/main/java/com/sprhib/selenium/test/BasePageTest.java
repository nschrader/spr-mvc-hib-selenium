package com.sprhib.selenium.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sprhib.selenium.pop.BasePage;

public abstract class BasePageTest<T extends BasePage> {
	protected final String ORGANIZATION_SELENIUM_TEST_NAME = "***Selenium Test Organization***";
	protected final String TEAM_SELENIUM_TEST_NAME = "***Selenium Test Team***";
	protected final String MEMBER_SELENIUM_TEST_NAME = "***Selenium Test Member***";
	protected final int TEAM_SELENIUM_TEST_RATING = 999; 
	
	protected T page;
	
	protected void assertIsOk(T page) throws Exception {
		assertThat(page.getTitle(), not(allOf(
			containsString("Apache"), containsString("Tomcat"), containsString("Error")
			)));
	}
	
	@After
	public void closeTheBrowser() {
		page.close();
	}
}
