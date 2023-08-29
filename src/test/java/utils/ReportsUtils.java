package utils;

import base.BasePage;
import io.cucumber.java.Scenario;
import io.qameta.allure.*;

import java.io.ByteArrayInputStream;

public class ReportsUtils{


    public void takeErrorScreenshot(Scenario scenario){

        if(scenario.isFailed()){
            try {
                byte[] screenshot = BasePage.takeScreenshot();
                scenario.attach(screenshot, "image/png",scenario.getName());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
