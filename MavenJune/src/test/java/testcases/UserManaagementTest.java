/*//TEST NG CLASS

package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import helper.BaseClass;
import pages.Login;
import pages.UserManagement;

public class UserManaagementTest extends BaseClass {


	Login login;
	UserManagement user;

	@Test(description="Testing Add user button", priority=0)
	public void UManageTest()
	{

		login=PageFactory.initElements(driver, Login.class);
		user=PageFactory.initElements(driver,UserManagement.class);

		logger=report.createTest("User Management Test");

		login.enterUsername("Admin");
		logger.info("username entered");

		login.enterPassword("admin123");
		logger.info("password entered");

		login.ClickLogin();
		logger.info("clicked on login button");

		//user.ValidatePage();
		//logger.pass("User validated site");

		user.hoverAdmin();
		logger.info("hovered on admin");

		user.Clickadd();
		logger.info("user clicked add button");

user.selectRole(role);
		logger.info("user selected a report");
		
		user.enterEmpname(name);
		logger.info("User entered employee name");
		
		user.enterUserName(username);
		logger.info("User entered username");
		
		user.selectStatus(status);
		logger.info("User selected status");
		
		user.enterpswd(pass);
		logger.info("User entered and confirmed password");
		
		user.clickSave();
		logger.info("user clicked on save");
	}
	
	@DataProvider(name="Sheet2") 
	// this data provider annotation  will get data from excel sheet
	public Object[] [] getDatafromsources() throws FileNotFoundException, IOException
	{
		System.out.println("LOG:INFO running Data PRovider first to generate date");
		int rows=DataProviderFactory.getExcel().getRows("Sheet2"); // gives total num of rows
		int columns=DataProviderFactory.getExcel().getColumns("Sheet2"); // gives total num of rows
	System.out.println("Total num of rows: "+rows);
	System.out.println("Total num of columns: "+columns);
	//Object[][] arr=new Object[1][2];

	Object[][] arr=new Object[rows-1][columns];

	for(int i=0;i<rows-1;i++)
	{
		for(int j=0;j<columns;j++)
		{
			
			//using i+1 cuz we dont want to use first row. avoing spill over  and we are also doing row-1 otherwise i will throe array out of bound exception
			arr[i][j]=DataProviderFactory.getExcel().getCellData("Sheet2", i+1, j);
		}

	}
	System.out.println("LOG: INFO Data provider is ready to use");
	return arr;
	}
	
}
*/





///////////////////////////////////////////////
package testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProviderFactory.DataProviderFactory;
import helper.BaseClass;
import pages.Login;
import pages.UserManagement;

public class UserManaagementTest extends BaseClass {
	
	Login login;
	UserManagement user;
	
	@Test(dataProvider="Sheet2",description = "Testing the Add User Button", priority=0)
	public void UMTest(String role,String name,String username,String status,String pass) {
		
		login = PageFactory.initElements(driver, Login.class);
		user = PageFactory.initElements(driver, UserManagement.class);
		
		logger = report.createTest("UM Test");
		
		login.enterUsername("admin");
		logger.info("User entered username");
		
		login.enterPassword("admin123");
		logger.info("User entered password");
		
		login.ClickLogin();
		logger.info("User clicked Login button");
		
		user.ValidatePage();
		logger.pass("User validated site");
		
		user.clickUserTab();
		logger.info("User hovered and clicked User tab");
		
		user.clickAddButton();
		logger.info("User clicked Add button");
		
		user.selectRole(role);
		logger.info("user selected a report");
		
		user.enterEmpname(name);
		logger.info("User entered employee name");
		
		user.enterUserName(username);
		logger.info("User entered username");
		
		user.selectStatus(status);
		logger.info("User selected status");
		
		user.enterpswd(pass);
		logger.info("User entered and confirmed password");
		
		user.clickSave();
		logger.info("user clicked on save");
	}
	
	@DataProvider(name="Sheet2") 
	// this data provider annotation  will get data from excel sheet
	public Object[] [] getDatafromsources() throws FileNotFoundException, IOException
	{
		System.out.println("LOG:INFO running Data PRovider first to generate date");
		int rows=DataProviderFactory.getExcel().getRows("Sheet2"); // gives total num of rows
		int columns=DataProviderFactory.getExcel().getColumns("Sheet2"); // gives total num of rows
	System.out.println("Total num of rows: "+rows);
	System.out.println("Total num of columns: "+columns);
	//Object[][] arr=new Object[1][2];

	Object[][] arr=new Object[rows-1][columns];

	for(int i=0;i<rows-1;i++)
	{
		for(int j=0;j<columns;j++)
		{
			
			//using i+1 cuz we dont want to use first row. avoing spill over  and we are also doing row-1 otherwise i will throe array out of bound exception
			arr[i][j]=DataProviderFactory.getExcel().getCellData("Sheet2", i+1, j);
		}

	}
	System.out.println("LOG: INFO Data provider is ready to use");
	return arr;
	}
	
}
