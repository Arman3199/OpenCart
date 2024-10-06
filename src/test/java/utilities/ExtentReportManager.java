package utilities;

import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public String reportName;
	
	
	 public void onStart(ITestContext context) {
		    //RegressionTest2024.09.29.html
		 	//Test-Report-2024.09.29.html
		 
	/*	 SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Date dt = new Date();
		 df.format(dt);
		 */
		
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 reportName = "Test-Report-" + timeStamp + ".html";
		 
		 sparkReporter = new ExtentSparkReporter("./reports/"+reportName);
		 
		 sparkReporter.config().setDocumentTitle("OpenCart Automation Report");
		 sparkReporter.config().setReportName("OpenCart Funtional Testing");
		 sparkReporter.config().setTheme(Theme.DARK);
		 
		 extent = new ExtentReports();
		 extent.attachReporter(sparkReporter);
		 extent.setSystemInfo("Application", "OpenCart");
		 extent.setSystemInfo("Module", "Admin");
		 extent.setSystemInfo("SubModule", "Customers");
		 extent.setSystemInfo("UserName", System.getProperty("user.name"));
		 extent.setSystemInfo("Environment", "QA");
		 
		 String os = context.getCurrentXmlTest().getParameter("OS");
		 extent.setSystemInfo("Operaing System", os);
		 String browser = context.getCurrentXmlTest().getParameter("browser");
		 extent.setSystemInfo("Browser", browser);
		 
		 List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		 
		 if(!includedGroups.isEmpty()) {
			 extent.setSystemInfo("Groups", includedGroups.toString());
		 }
		 
		  }
	 
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+ " got passed!");
		
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+ " failed!!");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
		String imgPath = new BaseClass().captureScreenshot(result.getName());
		test.addScreenCaptureFromPath(imgPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.SKIP, result.getName()+ " got skipped!!");
		test.log(Status.INFO, result.getThrowable().getMessage());
	
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"/reports/"+reportName;
		File extentReport = new File(pathOfExtentReport);
	
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
