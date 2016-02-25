package com.sprhib.selenium.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public abstract class Navbar extends BasePage {
	
	@FindBy(id="h")
	private WebElement home;
	
	@FindBy(id="o")
	private WebElement organization;
	
	@FindBy(id="o_add")
	private WebElement organization_add;
	
	@FindBy(id="o_list")
	private WebElement organization_list;
	
	@FindBy(id="t")
	private WebElement team;
	
	@FindBy(id="t_list")
	private WebElement team_list;
	
	@FindBy(id="t_add")
	private WebElement team_add;
	
	@FindBy(id="m")
	private WebElement member;
	
	@FindBy(id="m_list")
	private WebElement member_list;
	
	@FindBy(id="m_add")
	private WebElement member_add;
	
	@FindBy(id="l_en")
	private WebElement lang_en;
	
	@FindBy(id="l_de")
	private WebElement lang_de;
	
	public Navbar(WebDriver driver) {
		super(driver);
	}
	
	public void clickOrganizationAdd() {
		organization.click();
		organization_add.click();
	}
	
	public void clickOrganizationList() {
		organization.click();
		organization_list.click();
	}
	
	public void clickTeamAdd() {
		team.click();
		team_add.click();
	}
	
	public void clickTeamList() {
		team.click();
		team_list.click();
	}
	
	public void clickMemberAdd() {
		member.click();
		member_add.click();
	}
	
	public void clickMemberList() {
		member.click();
		member_list.click();
	}
	
	public void clickLangEn() {
		lang_en.click();
	}
	
	public void clickLangDe() {
		lang_de.click();
	}
	
	public String getOrganizationDropdownClass() {
		return organization.findElement(By.xpath("..")).getAttribute("class");
	}
	
	public String getTeamDropdownClass() {
		return team.findElement(By.xpath("..")).getAttribute("class");
	}
	
	public String getMemberDropdownClass() {
		return member.findElement(By.xpath("..")).getAttribute("class");
	}
	
	public String getLangDeContainerClass() {
		return lang_de.findElement(By.xpath("../..")).getAttribute("class");
	}
	
	public String getLangDeHref() {
		return lang_de.getAttribute("href");
	}
	
	public String getLangEnContainerClass() {
		return lang_en.findElement(By.xpath("../..")).getAttribute("class");
	}
	
	public String getLangEnHref() {
		return lang_en.getAttribute("href");
	}
}
 
