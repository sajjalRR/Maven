/*package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import helper.utility;

public class UserManagement {
	
	WebDriver driver;   //global variable
	
	public UserManagement(WebDriver d)  ///constructor  initializes the driver browser we will use
	{
		this.driver=d;
	}

	@FindBy(xpath="menu_admin_viewAdminModule")WebElement admin;
	@FindBy(id="menu_admin_UserManagement")WebElement usermanagement;
	@FindBy(id="menu_admin_viewSystemUsers")WebElement users;
	@FindBy(id="btnAdd")WebElement addbutton;
	
	
	public void ValidatePage()// validates if we are in correct testpage
	{
		utility.validateTitle(driver, "OrangeHRM");
	}
	
	public void hoverAdmin()
	{	
		Actions action = new Actions(driver);
		
		action.moveToElement(admin).build().perform();
		action.moveToElement(usermanagement).build().perform();
		utility.waitforWebElement(driver,users).click();
	}
	
	public void Clickadd()
	{
		utility.waitforWebElement(driver,addbutton).click();
		System.out.println("LOG:INFO clicked on add");
	}
	
	public void selectRole(String role)
	{
		Select dropdown =new Select(userRole);
		
		//one way to select from a dropdown
		if(role.equalsIgnoreCase("Admin"))
             {
			dropdown.selectByIndex(0);
	
             }
		
		else if(role.equalsIgnoreCase("ESS"))
		     {
			dropdown.selectByIndex(1);
		     }
		
		
		//another dropdown method
		
		//dropdown.selectByVisibleText(role);
	}
		
		public void enterEmpname(String name)
		{
			utility.waitforWebElement(driver, empName).sendKeys(name);
			System.out.println("LOG:INFO USer enteres a name");
		}
	
		public void enterUserName(String name)
		{
			utility.waitforWebElement(driver, userName).sendKeys(name);
			System.out.println("LOG:INFO USer enteres a user name");
		}
	

		public void selectStatus(String stat)
		{
			Select dropdown =new Select(status);
			
			//one way to select from a dropdown
			if(stat.equalsIgnoreCase("Enabled"))
	             {
				dropdown.selectByIndex(0);
	             }
			
			else if(stat.equalsIgnoreCase("disbaled"))
			     {
				dropdown.selectByIndex(1);
			     }
			
			//dropdown.selectByVisibleText(stat);
			System.out.println("LOG:INFO User selected a status");
		}
	public void enterpswd(String pass)
		{
			utility.waitforWebElement(driver, password).sendKeys(pass);
			utility.waitforWebElement(driver, confPassword).sendKeys(pass);
			System.out.println("LOG:INFO USer entered password and confirmed passsword");
		}
	public void clickSave()
	    {
		utility.waitforWebElement(driver, saveButton).click();
		System.out.println("user clicked save button");
	    }
	
	
	
	
}
*/

/////////////////////////////////////////////////////////////
package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import helper.utility;

public class UserManagement {
	
	WebDriver driver;
	
	public UserManagement(WebDriver d)
	{
		this.driver = d;
	}
	
	@FindBy(id = "menu_admin_viewAdminModule") WebElement adminTab;
	@FindBy(id = "menu_admin_UserManagement") WebElement managementTab;
	@FindBy(id = "menu_admin_viewSystemUsers") WebElement userTab;
	@FindBy(id = "btnAdd") WebElement addButton;
	
	
	@FindBy(id = "systemUser_userType") WebElement userRole;
	@FindBy(id = "systemUser_employeeName_empName") WebElement empName;
	@FindBy(id = "systemUser_userName") WebElement userName;
	@FindBy(id = "systemUser_status") WebElement status;
	@FindBy(id = "systemUser_password") WebElement password;
	@FindBy(id = "systemUser_confirmPassword") WebElement confPassword;
	@FindBy(id = "btnSave") WebElement saveButton;
	
	public void ValidatePage()
	{
		utility.validateTitle(driver, "OrangeHRM");
	}
	
	public void clickUserTab()
	{
		Actions action = new Actions(driver);
		
		action.moveToElement(adminTab).build().perform();
		action.moveToElement(managementTab).build().perform();
		
		utility.waitforWebElement(driver, userTab).click();
		
		System.out.println("LOG:INFO Clicked on User button");
	}
	
	public void clickAddButton()
	{
		utility.waitforWebElement(driver, addButton).click();
		System.out.println("LOG:INFO Click on Add button");
	}

	public void selectRole(String role)
	{
		Select dropdown =new Select(userRole);
		
		//one way to select from a dropdown
		if(role.equalsIgnoreCase("Admin"))
             {
			dropdown.selectByIndex(0);
	
             }
		
		else if(role.equalsIgnoreCase("ESS"))
		     {
			dropdown.selectByIndex(1);
		     }
		
		
		//another dropdown method
		
		//dropdown.selectByVisibleText(role);
	}
		
		public void enterEmpname(String name)
		{
			utility.waitforWebElement(driver, empName).sendKeys(name);
			System.out.println("LOG:INFO USer enteres a name");
		}
	
		public void enterUserName(String name)
		{
			utility.waitforWebElement(driver, userName).sendKeys(name);
			System.out.println("LOG:INFO USer enteres a user name");
		}
	

		public void selectStatus(String stat)
		{
			Select dropdown =new Select(status);
			
			//one way to select from a dropdown
			if(stat.equalsIgnoreCase("Enabled"))
	             {
				dropdown.selectByIndex(0);
	             }
			
			else if(stat.equalsIgnoreCase("disbaled"))
			     {
				dropdown.selectByIndex(1);
			     }
			
			//dropdown.selectByVisibleText(stat);
			System.out.println("LOG:INFO User selected a status");
		}
	public void enterpswd(String pass)
		{
			utility.waitforWebElement(driver, password).sendKeys(pass);
			utility.waitforWebElement(driver, confPassword).sendKeys(pass);
			System.out.println("LOG:INFO USer entered password and confirmed passsword");
		}
	public void clickSave()
	    {
		utility.waitforWebElement(driver, saveButton).click();
		System.out.println("user clicked save button");
	    }
	
}
