package com.sprhib.selenium.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sprhib.selenium.pop.MemberListPage;

public class MemberListPageTest extends MemberEditPageTest<MemberListPage> {
	private final String MEMBER_SELENIUM_URL = "http://localhost:8080/spr-mvc-hib/member/?lang=en";
	
	@Before
	public void openTheBrowser() {
		page = PageFactory.initElements(new FirefoxDriver(), MemberListPage.class);
		page.open(MEMBER_SELENIUM_URL);
	}
	
	@Test
	public void noEmptyTableCells() throws Exception {
		for (String[] s: page.getTableCells()) {
			for (String p: s) {
				assertFalse(p.isEmpty());
			}
		}
	}
	
	/*
	 * It is some kind of ugly what we are doing here, but we need to perform a three-in-one test
	 * because MemberEdit and MemberDelete depend on MemberList to get the test enity's ID.
	 * Basically we are trying to find our test entiy, then we will edit it and finally we will delete it.
	 */	
	@Test
	public void gotoActions() throws Exception {
		int id = -1;
		List<String[]> s = page.getTableCells();
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i)[1].equals(MEMBER_SELENIUM_TEST_NAME))
				id = i;
		}
		if (id == -1)
			throw new Exception("Test entry not found. Was looking for " + MEMBER_SELENIUM_TEST_NAME);
		else {
			page.clickEdit(id);
			assertIsOk(page);
			assertThat(page.getUrl(), containsString("/member/edit/"));
			editBlankMember();
			editMember();
			page.open(MEMBER_SELENIUM_URL);
			page.clickDelete(id);
			assertIsOk(page);
			assertThat(page.getUrl(), containsString("/member/delete/"));
		}
	}
} 
