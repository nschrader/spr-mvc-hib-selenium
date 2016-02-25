package com.sprhib.selenium.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sprhib.selenium.pop.TeamAddEditPage;

public abstract class TeamEditPageTest<T extends TeamAddEditPage> extends NavbarTest<T> {
	protected void editBlankTeam() throws Exception {
		page.typeName("");
		page.typeRating(null);
		page.submitForm();
		assertIsOk(page);
		assertThat(page.getTitle(), not(containsString("Home")));
	}
	
	protected void editTeam() throws Exception {
		page.typeName(TEAM_SELENIUM_TEST_NAME);
		page.typeRating(TEAM_SELENIUM_TEST_RATING);
		page.submitForm();
		assertIsOk(page);
		assertThat(page.getTitle(), containsString("Home"));
	}
} 
