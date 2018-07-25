package by.htp.drozdovskaya.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import by.htp.drozdovskaya.automation.entity.Letter;

public class LetterFramePage extends AbstractPage {

	public LetterFramePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void sendLetter(Letter letter) {
		
		driver.findElements(By.xpath("//div/child::textarea[@class='js-input compose__labels__input']")).get(0).sendKeys(letter.getAdress());
		driver.findElement(By.xpath("//div[@class='compose-head__field']/child::input")).sendKeys(letter.getSubject());
		WebDriver driver2 = driver.switchTo().frame(driver.findElement(By.xpath("//td[@class='mceIframeContainer mceFirst mceLast']/child::iframe")));
		driver2.findElement(By.xpath("/html/child::body")).sendKeys(letter.getContent());
		driver = driver2.switchTo().parentFrame();
		driver.findElements(By.xpath("//ancestor::div[@data-name='send']")).get(0).click();
		
	}
	
	public String getCurrentLetterFramePageName()
	{
		return driver.getCurrentUrl();
	}

	@Override
	public void openPage() {
		driver.navigate().to(getCurrentLetterFramePageName());
	}

}
