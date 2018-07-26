package by.htp.drozdovskaya.automation.steps;

import org.openqa.selenium.WebDriver;


import by.htp.drozdovskaya.automation.driver.DriverSingleton;
import by.htp.drozdovskaya.automation.entity.Letter;
import by.htp.drozdovskaya.automation.pages.LetterFramePage;
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
	
	public boolean isLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		return actualUsername.equals(username);
	}
	public String writeLetter() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnWriteLetter();
		return mainPage.getCurrentMainInboxPageName();
	}
	
	public void sendLetter(Letter letter) {
		LetterFramePage letterPage = new LetterFramePage(driver);
		letterPage.sendLetter(letter);
		System.out.println();
	}
	public String getTextAboutSendLetter() {
		LetterFramePage letterPage = new LetterFramePage(driver);
		return letterPage.getTextAboutSendLetter();
	}

}