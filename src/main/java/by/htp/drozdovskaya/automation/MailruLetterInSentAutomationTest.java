package by.htp.drozdovskaya.automation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.htp.drozdovskaya.automation.entity.Letter;
import by.htp.drozdovskaya.automation.steps.Steps;

public class MailruLetterInSentAutomationTest {

	private Steps steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";
	private Letter letter;

	@BeforeTest(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
		letter = new Letter("arty.drozdovskiy@gmail.com", "vica testing", "Hello pirajusik moy");
	}
	
	@BeforeMethod
	public void login() {
		steps.loginMailru(USERNAME, PASSWORD);
		steps.writeLetter();
	}
	@BeforeMethod
	public void sendLetter() {
		steps.sendLetter(letter);
	}

	@Test(description = "Letter in Sent Mail.ru")
	public void isLetterInSentMailru()
	{
		Assert.assertTrue(steps.findLetteInSentPage(letter));
	}

	@AfterTest(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}
}
