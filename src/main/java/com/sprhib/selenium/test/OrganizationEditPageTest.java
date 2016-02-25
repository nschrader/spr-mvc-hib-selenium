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

public abstract class OrganizationEditPageTest<T extends OrganizationAddEditPage> extends NavbarTest<T> {
	protected void editBlankOrganization() throws Exception {
		page.typeName("");
		page.submitForm();
		assertIsOk(page);
		assertThat(page.getTitle(), not(containsString("Home")));
	}
	
	protected void editOrganization() throws Exception {
		page.typeName(ORGANIZATION_SELENIUM_TEST_NAME);
		page.submitForm();
		assertIsOk(page);
		assertThat(page.getTitle(), containsString("Home"));
	}
} 
