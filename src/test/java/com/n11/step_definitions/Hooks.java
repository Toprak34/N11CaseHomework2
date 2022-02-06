package com.n11.step_definitions;

import com.n11.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;

    @Before
    public void setUp() {

        Driver.get().manage().window().maximize();
        Driver.get().manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        action = new Actions(Driver.get());
    }

    @After
    public void tearDown(Scenario n11test) {
        //Take screenshot in allure report
        if (n11test.isFailed()){
            Allure.addAttachment(n11test.getName(),new ByteArrayInputStream(((TakesScreenshot)driver)
                    .getScreenshotAs(OutputType.BYTES)));
        }
        Driver.closeDriver();
    }
}
