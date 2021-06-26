// This class will just have testcases in methods form and will not run anything like the rectangle class.We pass values from LoginTest file 
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.utility;

public class Login {
	
	WebDriver driver;   //global variable
	
	public Login(WebDriver d)  ///constructor  initializes the driver browser we will use
	{
		this.driver=d;
	}

	
	
	@FindBy(id="txtUsername")WebElement username; // Storing WebElement username
	
	@FindBy(id="txtPassword")WebElement password;
	//@FindBy(xpath="//*[@id=\"btnLogin\"]")WebElement loginButton;
	@FindBy(xpath="//input[@value='LOGIN']")WebElement loginButton; //Custom xpath

public void ValidateHomepage()

{utility.validateTitle(driver,"OrangeHRM");
	
}

public void enterUsername(String s)
{
	System.out.println("LOG :INFO Username entered");
	utility.waitforWebElement(driver, username).sendKeys(s); //waits fr username element to load properly and then send data
}

public void enterPassword(String p)
{
	System.out.println("LOG :INFO password entered");
	utility.waitforWebElement(driver, password).sendKeys(p); //waits fr pswd element to load properly and then send data
}

public void ClickLogin()
{
	utility.waitforWebElement(driver,loginButton).click();
	System.out.println("LOG:INFO clicked on login button");
}


}
