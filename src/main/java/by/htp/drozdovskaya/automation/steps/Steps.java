package by.htp.drozdovskaya.automation.steps;

import org.openqa.selenium.WebDriver;


import by.htp.drozdovskaya.automation.driver.DriverSingleton;
import by.htp.drozdovskaya.automation.pages.LoginPage;
import by.htp.drozdovskaya.automation.pages.MainPage;

public class Steps {
	
	private WebDriver driver;

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		DriverSingleton.closeDriver();
	}

	public void loginMailru(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}
	
	public void writeLetter() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnWriteLetter();
	}

}