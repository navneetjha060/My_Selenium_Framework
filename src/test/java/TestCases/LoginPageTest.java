package TestCases;

import java.io.IOException;

import org.testng.Assert;
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
	public void loginPageTitleTest() {

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
	public void loginTest() throws IOException {

		homepage = Login.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		extent.flush();

	}

}
