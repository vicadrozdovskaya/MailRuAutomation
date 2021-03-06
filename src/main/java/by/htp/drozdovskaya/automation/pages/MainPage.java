package by.htp.drozdovskaya.automation.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://e.mail.ru/messages/inbox";


	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnWriteLetter()
	{
		driver.findElement(By.xpath("//div[@class='b-toolbar__item']/child::a")).click();

	}
	public String getCurrentMainInboxPageName()
	{
		Pattern pat = Pattern.compile("[a-z:/.]+");
		Matcher matcher = pat.matcher(driver.getCurrentUrl());
		matcher.find();
		return matcher.group();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(getCurrentMainInboxPageName());
	}

}
