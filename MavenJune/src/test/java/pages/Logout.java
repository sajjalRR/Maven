package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.utility;

public class Logout {
	
	WebDriver driver;
    
	
	public Logout(WebDriver d)
	{
		this.driver=d;
	}
	
	@FindBy(id="welcome")WebElement welcomeButton;// (name of web element you can write anything you want)
	
	@FindBy(xpath="//*[@id=\"welcome-menu\"]/ul/li[3]/a")WebElement logOut;
	
	public void clickLogout()
	{
		utility.waitforWebElement(driver,welcomeButton).click();
		utility.waitforWebElement(driver,logOut).click();
		System.out.println("LOG:INFO Clicked on logout button");
	}
	
}
