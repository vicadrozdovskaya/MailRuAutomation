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

public class MailruSendLetterAutomationTest {

	private Steps steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";
	
	@DataProvider(name = "collectionData")
	public Iterator<Letter> collectionTestData(){
		List<Letter> data = new ArrayList<>();
		data.add(new Letter("arty.drozdovskiy@gmail.com", "vica testing", "Hello pirajusik moy"));
		data.add(new Letter("vica.drozdovskaya@gmail.com", "vica testing", "Hello from me"));		
		return data.iterator();
	}

	@BeforeTest(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}
	
	@BeforeMethod
	public void login() {
		steps.loginMailru(USERNAME, PASSWORD);
		steps.writeLetter();
	}

	@Test(description = "Send letter Mail.ru", dataProvider = "collectionData")
	public void canSendLetterfromMailru(Letter actual)
	{
		steps.sendLetter(actual);
		Assert.assertEquals("Ваше письмо отправлено. Перейти во Входящие", steps.getTextAboutSendLetter());
	}

	@AfterTest(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}
}
