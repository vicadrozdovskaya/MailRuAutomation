package by.htp.drozdovskaya.automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.drozdovskaya.automation.steps.Steps;

public class MailruWriteLetterAutomationTest {


	private Steps steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";

	@BeforeTest(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}
	
	@BeforeMethod
	public void login() {
		steps.loginMailru(USERNAME, PASSWORD);
	}

	@Test(description = "Write letter Mail.ru")
	public void oneCanWriteLetterfromMailru()
	{
		steps.writeLetter();
	}

	@AfterTest(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}
}
