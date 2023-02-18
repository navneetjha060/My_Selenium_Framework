package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class LoginPage extends BaseClass {

	// Page Factory - Object Repository
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement Logo;

	// Initializing the Page Objects
	public LoginPage() throws IOException {

		PageFactory.initElements(driver, this);

	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {
		return Logo.isDisplayed();
	}

	public HomePage login(String uname, String pwd) throws IOException {

		username.sendKeys(uname);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();

	}

}
