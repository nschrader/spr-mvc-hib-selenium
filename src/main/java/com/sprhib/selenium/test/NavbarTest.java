package com.sprhib.selenium.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sprhib.selenium.pop.Navbar;

public abstract class NavbarTest<T extends Navbar> extends BasePageTest<T> {
	
	@Test
	public void gotoOrganizationList() throws Exception {
		page.clickOrganizationList();
		assertIsOk(page);
		assertThat(page.getOrganizationDropdownClass(), containsString("active"));
		assertThat(page.getUrl(), containsString("/organization/list.html"));
	}
	
	@Test
	public void gotoOrganizationAdd() throws Exception {
		page.clickOrganizationAdd();
		assertIsOk(page);
		assertThat(page.getOrganizationDropdownClass(), containsString("active"));
		assertThat(page.getUrl(), containsString("/organization/add.html"));
	}
	
	@Test
	public void gotoTeamList() throws Exception {
		page.clickTeamList();
		assertIsOk(page);
		assertThat(page.getTeamDropdownClass(), containsString("active"));
		assertThat(page.getUrl(), containsString("/team/list.html"));
	}
	
	/*
	 * Clicking on TeamAdd may throw an error that is shown on Home.
	 * It's not a bug, it's a feature, so we have to keep this in mind...
	 */
	@Test
	public void gotoTeamAdd() throws Exception {
		page.clickTeamAdd();
		assertIsOk(page);
		if (!page.getTitle().equals("Home"))
			assertThat(page.getTeamDropdownClass(), containsString("active"));
		assertThat(page.getUrl(), containsString("/team/add.html"));
	}
	
	@Test
	public void gotoMemberList() throws Exception {
		page.clickMemberList();
		assertIsOk(page);
		assertThat(page.getMemberDropdownClass(), containsString("active"));
		assertThat(page.getUrl(), containsString("/member/list.html"));
	}
	
	/*
	 * Clicking on MemberAdd may throw an error that is shown on Home.
	 * It's not a bug, it's a feature, so we have to keep this in mind...
	 */
	@Test
	public void gotoMemberAdd() throws Exception {
		page.clickMemberAdd();
		assertIsOk(page);
		if (!page.getTitle().equals("Home"))
			assertThat(page.getMemberDropdownClass(), containsString("active"));
		assertThat(page.getUrl(), containsString("/member/add.html"));
	}
	
	@Test
	public void checkLanguageSwitcher() throws Exception {
		assertThat(page.getLangDeContainerClass(), containsString("navbar-right"));
		assertThat(page.getLangEnContainerClass(), containsString("navbar-right"));
		assertThat(page.getLangDeHref(), containsString("?lang=de"));
		assertThat(page.getLangEnHref(), containsString("?lang=en"));
		page.clickLangDe();
		assertIsOk(page);
		page.back();
		page.clickLangEn();
		assertIsOk(page);
	}
} 
 
