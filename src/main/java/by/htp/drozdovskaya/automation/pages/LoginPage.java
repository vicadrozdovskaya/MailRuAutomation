package by.htp.drozdovskaya.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

	private final String BASE_URL = "https://mail.ru/login";
	private WebElement inputLogin;
	private WebElement inputPassword;
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
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));
		inputLogin = driver.findElement(By.xpath("//input[@name='Login']"));
		inputLogin.sendKeys(username);
		driver.findElement(By.xpath("//button[@class = 'c0187 c0170 c0192 c0175 c0188 c0171']")).click();
		inputPassword = driver.findElement(By.xpath("//div[@class='c0137 c0142 c0143']/child::input"));
		inputPassword.sendKeys(password);
		buttonSubmit = driver.findElement(By.xpath("//div/child::button[@data-test-id='next-button']"));
		buttonSubmit.click();
	}
	public String getLoggedInUserName()
	{
		return driver.findElement(By.xpath("//span[@id='PH_authMenu_button']/child::i[@id='PH_user-email']")).getText(); 
	}
	

}