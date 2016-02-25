package com.sprhib.selenium.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sprhib.selenium.pop.HomePage;

public class HomePageTest extends NavbarTest<HomePage> {

	@Before
	public void openTheBrowser() {
		page = PageFactory.initElements(new FirefoxDriver(), HomePage.class);
		page.open("http://localhost:8080/spr-mvc-hib/?lang=en");
	}
	
	@Test
	public void headerAndTitleSet() throws Exception {
		assertThat(page.getTitle(), containsString("Home"));
		assertThat(page.getHeader(), containsString("Welcome"));
	}
} 
