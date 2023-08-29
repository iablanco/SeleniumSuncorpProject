package runner;

import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.Allure;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        //plugin = { "pretty", "html:target/cucumber-reports"},
        plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true,
        tags = "@Smoke"
)

public class runner {


    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}
