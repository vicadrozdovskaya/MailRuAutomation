package by.htp.drozdovskaya.automation.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

	private static WebDriver driver;
	private final static String CHROME = "webdriver.chrome.driver";
	private final static String CHROME_PATH = "C:\\Drivers\\chromedriver\\chromedriver.exe";
	
    private DriverSingleton(){};


    public static WebDriver getDriver(){
        if (null == driver){
        	System.setProperty(CHROME, CHROME_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
