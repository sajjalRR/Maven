
  ///START BROWSER GENERATES REPORT . WORK of BASECLASS
package helper;

import org.testng.annotations.Test;
import helper.utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dataProviderFactory.DataProviderFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
  

  
  @BeforeClass
  public void beforeClass() throws FileNotFoundException, IOException {
	  
	  
	  System.out.println("LOG INFO:Before suite running...setting up report");
	  ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/ETReport"+utility.getTime()+".html"));
	  report=new ExtentReports();
	  report.attachReporter(reporter);
	  System.out.println("Log info:After suite running....reports are ready to use");
	  
	 
	  System.out.println("Log info:Creating browser session");
	  driver=browserFactory.StartBrowser(DataProviderFactory.getConfig().getBrowser(),DataProviderFactory.getConfig().getStagingURL());
	  System.out.println("Log info:Browser session created");

  }
  
  @AfterMethod
  public void appendReport(ITestResult result) throws IOException// 
  {
	  System.out.println("Test Name"+ result.getName());
	  System.out.println("LOG INFO:After method running..Generating Test Report");
      int status=result.getStatus(); // result,get status gives us numbers 0 1 showing pass/fail
      if(status==ITestResult.SUCCESS)
      {  
    	  logger.pass("Test scenario passed",MediaEntityBuilder.createScreenCaptureFromPath(utility.captureScreenshot(driver)).build());
    	  
      }
      
      else if(status==ITestResult.FAILURE)
      {
    	  logger.fail("test failed"+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(utility.captureScreenshot(driver)).build());
    	  
      }
      
      else if(status==ITestResult.SKIP)
      {
    	  logger.skip("Test scenario skipped");
    	  
    	  
      }
      
      report.flush();
  
  System.out.println("LOg info:After method executed...Test Result ");
  
  }
  

  @AfterClass
  public void closeSession() {
	  
	  System.out.println("LOG INFO:CLOSING BROWSER SESSION");
	  driver.quit();
	  System.out.println("LOG INFO:Browser session closed");
  }



}
