package page;

import base.FactoryBrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;
    private static JavascriptExecutor js;

    private static PropertiesReader propertiesReader;

    static {

        try {
            propertiesReader = new PropertiesReader();
            driver = FactoryBrowserDriver.getDriver(propertiesReader.getProperties().getProperty("browser"));
            js = (JavascriptExecutor) driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }


    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    private WebElement find(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private WebElement getElement(By by){
        return driver.findElement(by);
    }

    public void clickElement(By by){
        find(by).click();
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void write(By by, String textToWrite){
        find(by).clear();
        find(by).sendKeys(textToWrite);

    }

    public void dropDownSelectByValue(By dropDownlocator, String value){
        Select dropDonwList = new Select(find(dropDownlocator));
    }

    public void hoverOverElement(By by){
        action.moveToElement(find(by));
    }

    public void doubleClick(By by){
        action.doubleClick(find(by));
    }

    public void rightClick(By by){
        action.contextClick(find(by));
    }

    public void switcToIframe(int iframeindex){
        driver.switchTo().frame(iframeindex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromElement(By by){
        return find(by).getText();
    }

    public boolean elementIsDisplayed(By by){
        return getElement(by).isDisplayed();
    }

    //Verify the element is enable
    public boolean elementIsEnabled(By by){
        return find(by).isEnabled();
    }

    //Verify that element is selected
    public boolean elementIsSelected(By by){
        return find(by).isSelected();
    }

    public List<WebElement> getWebElements(By by){
        return driver.findElements(by);
    }

    public void waitForInvisibiltyOfElement(By by){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForVisisibilty(By by){
        wait.until(ExpectedConditions.visibilityOf(find(by)));
    }

    public void waitForPlaceholderElement(By by, String placeholder ,String value ){
        wait.until(ExpectedConditions.domPropertyToBe(getElement(by),placeholder,value));
    }

    public void scrollUntilElementIsVisible(By by){
        js.executeScript("arguments[0].scrollIntoView();", find(by));
    }




}
