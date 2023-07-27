package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FactoryBrowserDriver {

    private static WebDriver driver;
    public static WebDriver getDriver(String browser){
        if(browser.equals("chrome")){
            if(driver == null) {
                driver = new ChromeDriver(getChromOptions());
            }
        } else if(browser.equals("firefox")){
            driver = new FirefoxDriver(getFirefoxOptions());
        }

        return driver;
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--remote-allow-origins=*");
        return firefoxOptions;
    }

    private static ChromeOptions getChromOptions() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("start-maximized");
            return chromeOptions;
        }
}
