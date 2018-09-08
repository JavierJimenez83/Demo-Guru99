package guru99PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99Manager {

	//WebDriver + Locators
	private WebDriver driver;
	By titleLocator = By.className("barone");
	By manageridLocator = By.xpath("//table//tr[@class='heading3']");
	
	//Constructor
	public Guru99Manager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Methods - Get, set, click
	public String getTitle()
	{
		return driver.findElement(titleLocator).getText();
	}
	
	public String getManagerID()
	{
		return driver.findElement(manageridLocator).getText();
	}
}
