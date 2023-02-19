package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;

public class LoginPageTest extends BaseClass {

	LoginPage Login;
	HomePage homepage;
	ExtentReports extent;

	static Logger Log = LogManager.getLogger(LoginPageTest.class);

	public LoginPageTest() throws IOException {
		super();

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("DemoExtent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@BeforeMethod
	public void setUp() throws IOException {
		launchBrowser();
		Login = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() throws InterruptedException {

		Log.trace("TC-1 Started");
		ExtentTest test = extent.createTest("TC-01", "This is Login Page Title Test");
		String Title = Login.validateLoginPageTitle();
		String Expected = "Free CRM - CRM software for customer relationship management, sales, and support.";

		if (Title.equals(Expected)) {
			test.pass("Test Case Passed Successfully");
		}

		else {
			test.fail("Test Case Failed");
		}

	}

	@Test(priority = 2)
	public void validateLogo() {
		Log.trace("TC-2 Started");
		ExtentTest test = extent.createTest("TC-02", "This is Logo Validation Test");
		boolean res = Login.validateLogo();
		if (res) {
			test.pass("Test Case Passed Successfully");
		}

		else {
			test.fail("Test Case Failed");
		}
	}

	@Test(priority = 3)
	public void loginTest() throws IOException, InterruptedException {
		Log.trace("TC-3 Started");
		ExtentTest test = extent.createTest("TC-03", "This is Login Functionality Test");
		homepage = Login.login(prop.getProperty("username"), prop.getProperty("password"));
		test.pass("Test Case Passed Successfully");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		extent.flush();

	}

}
