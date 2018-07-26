package by.htp.drozdovskaya.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import by.htp.drozdovskaya.automation.entity.Letter;

public class SentLetterPage extends AbstractPage {

	public SentLetterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public Letter getSentLetter() {
		Letter letter = new Letter();
		letter.setAdress(driver.findElement(By.xpath("//span[@class='b-letter__head__addrs__value']/child::span"))
				.getAttribute("data-contact-informer-email"));
		letter.setSubject(driver.findElement(By.xpath("//div[@class='b-letter__head__subj__text']")).getText());
//		String str = driver.findElement(By.xpath("//div[@id='style_15326341470000000728_BODY']/child::div")).getText();
//		System.out.println(str);
//		letter.setContent(str);
		return letter;
	}

	public String getCurrentSentLetterPageName() {
		return driver.getCurrentUrl();
	}

	@Override
	public void openPage() {
		driver.navigate().to(getCurrentSentLetterPageName());
	}

}
