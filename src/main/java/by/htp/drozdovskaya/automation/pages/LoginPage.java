package by.htp.drozdovskaya.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

	private final String BASE_URL = "https://mail.ru/login";

	@FindBy(xpath = "div[@class='c0137 c0142']/child::input") 
	private WebElement inputLogin;

	@FindBy(xpath = "//div[@class='c0137 c0142 c0143']/child::input")
	private WebElement inputPassword;

	@FindBy(xpath = "//div/child::button[@data-test-id='submit-button']")
	private WebElement buttonSubmit;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}

	public void login(String username, String password)
	{
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
	}

}
