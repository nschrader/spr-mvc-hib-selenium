package com.sprhib.selenium.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sprhib.selenium.pop.MemberAddEditPage;

public abstract class MemberEditPageTest<T extends MemberAddEditPage> extends NavbarTest<T> {
	protected void editBlankMember() throws Exception {
		page.typeName("");
		page.setTeam(null);
		page.submitForm();
		assertIsOk(page);
		assertThat(page.getTitle(), not(containsString("Home")));
	}
	
	protected void editMember() throws Exception {
		page.typeName(MEMBER_SELENIUM_TEST_NAME);
		page.setTeam(0);
		page.submitForm();
		assertIsOk(page);
		assertThat(page.getTitle(), containsString("Home"));
	}
} 
