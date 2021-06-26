package testcases; //this is a TestNG class in it we we will have alot of classes  and this class created object for login class

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProviderFactory.DataProviderFactory;
import helper.BaseClass;
import pages.Login;
import pages.Logout;

public class LogInTest extends BaseClass { //added extend baseclass for driver to exist
	
	Login login; //created object for the class login that we created 
	Logout lout;
  @Test(description = "Log in to OrangeHRM", priority = 0)
  public void loginHRM() {
	  
	  login=PageFactory.initElements(driver,Login.class); // initializing the webdriver  //Login login=new Login( initioalizing the     obj login
	  lout=PageFactory.initElements(driver,Logout.class);
	  
	  
	  
	  logger=report.createTest("Login Test for Orange hrm");//LOgger used for reports generation we see in the end
	  logger.pass("Home Page validated");
	  login.enterUsername("Admin");
	  logger.info("username entered");
	  login.enterPassword("admin123");
	  logger.info("password entered");
	  login.ClickLogin();
	  logger.info("clicked on login button");
	  
	  lout.clickLogout();
	  logger.info("Clicked on logout button");
	  
  }
  
  @Test(dataProvider="Sheet1",description="Log in to ORangeHRM using Excel,priority=1")

public void LoginHRMExcel(String uname,String pass)
{	  
	  login=PageFactory.initElements(driver,Login.class); // initializing the webdriver  //Login login=new Login( initioalizing the     obj login
	  lout=PageFactory.initElements(driver,Logout.class);
	  
	  
	  
	  logger=report.createTest("Login Test for Orange hrm");//LOgger used for reports generation we see in the end
	  logger.pass("Home Page validated");
	  login.enterUsername(uname); //Providing username from excel
	  logger.info("username entered");
	  login.enterPassword(pass);//Providing pass from excel
	  logger.info("password entered");
	  login.ClickLogin();
	  logger.info("clicked on login button");
	  
	  lout.clickLogout();
	  logger.info("Clicked on logout button");
	  
}

@DataProvider(name="Sheet1") 
// this data provider annotation  will get data from excel sheet
public Object[] [] getDatafromsources() throws FileNotFoundException, IOException
{
	System.out.println("LOG:INFO running Data PRovider first to generate date");
	int rows=DataProviderFactory.getExcel().getRows("Sheet1"); // gives total num of rows
	int columns=DataProviderFactory.getExcel().getColumns("Sheet1"); // gives total num of rows
System.out.println("Total num of rows: "+rows);
System.out.println("Total num of columns: "+columns);
//Object[][] arr=new Object[1][2];

Object[][] arr=new Object[rows-1][columns];

for(int i=0;i<rows-1;i++)
{
	for(int j=0;j<columns;j++)
	{
		
		//using i+1 cuz we dont want to use first row. avoing spill over  and we are also doing row-1 otherwise i will throe array out of bound exception
		arr[i][j]=DataProviderFactory.getExcel().getCellData("Sheet1", i+1, j);
	}

}
System.out.println("LOG: INFO Data provider is ready to use");
return arr;
}

}

  

