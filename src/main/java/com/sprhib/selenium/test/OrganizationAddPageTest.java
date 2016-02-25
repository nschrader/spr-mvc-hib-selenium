package com.sprhib.selenium.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sprhib.selenium.pop.OrganizationAddEditPage;

public class OrganizationAddPageTest extends NavbarTest<OrganizationAddEditPage> {
	
	@Before
	public void openTheBrowser() {
		page = PageFactory.initElements(new FirefoxDriver(), OrganizationAddEditPage.class);
		page.open("http://localhost:8080/spr-mvc-hib/organization/add/?lang=en");
	}
	
	@Test
	public void addBlankOrganization() throws Exception {
		page.typeName("");
		page.submitForm();
		assertIsOk(page);
		assertThat(page.getTitle(), not(containsString("Home")));
	}
	
	@Test
	public void addOrganization() throws Exception {
		page.typeName(ORGANIZATION_SELENIUM_TEST_NAME);
		page.submitForm();
		assertIsOk(page);
		assertThat(page.getTitle(), containsString("Home"));
	}
} 
