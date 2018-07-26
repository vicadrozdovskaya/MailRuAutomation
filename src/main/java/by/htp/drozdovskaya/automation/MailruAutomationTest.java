package by.htp.drozdovskaya.automation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.drozdovskaya.automation.steps.Steps;

public class MailruAutomationTest {

	private Steps steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Login to Mail.ru")
	public void oneCanloginMailru()
	{
		steps.loginMailru(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn("tathtp@mail.ru"));
	
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}
}
