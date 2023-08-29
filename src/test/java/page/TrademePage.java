package page;

import base.BasePage;
import org.openqa.selenium.By;
import utils.Locators;

public class TrademePage extends BasePage {

    private String searchLabelLocator = Locators.searchLabelLocator;
    private String searchTextBoxLocator = Locators.searchTextBoxLocator;
    private String searchBtnLocator = Locators.searchBtnLocator;
    private String searchResultText = Locators.searchResultText;

    public TrademePage() {
        super(driver);
    }



    public void writeInputSearch(String productName) {
        clickElement(By.xpath(searchLabelLocator));
        waitForPlaceholderElement(By.xpath(searchTextBoxLocator),"placeholder","");
        write(By.xpath(searchTextBoxLocator), productName);
    }

    public void clickSearchBtn(){
        clickElement(By.xpath(searchBtnLocator));
    }

    public String getProductOfResultText() {
        scrollUntilElementIsVisible(By.xpath(searchResultText));
        String product = getTextFromElement(By.xpath(searchResultText));
        String[] p = product.split(" ",5);
        product = p[4];

        return product.replace("'","");
    }
}
