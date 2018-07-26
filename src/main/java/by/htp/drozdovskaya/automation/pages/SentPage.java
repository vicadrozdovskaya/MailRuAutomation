package by.htp.drozdovskaya.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import by.htp.drozdovskaya.automation.entity.Letter;

public class SentPage extends AbstractPage {

	private final String BASE_URL = "https://e.mail.ru/messages/sent/";

	public SentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public boolean isLetterSent(Letter letter) {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='b-datalist__item__body']/child::a"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAttribute("title").equals(letter.getAdress())
					&& list.get(i).getAttribute("data-subject").equals(letter.getSubject())) {
				list.get(i).click();
				return true;
			}
		}
		return false;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
