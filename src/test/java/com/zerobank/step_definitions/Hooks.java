package com.zerobank.step_definitions;

import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @Before
    public void setup(){
        Driver.get().manage().window().maximize();
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
        HomePage homePage= new HomePage();
        homePage.signinButton.click();
    }

    @After
    public void tearDown(Scenario scenario) {

        // if scenario fails, take a screenshot
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        Driver.closeDriver();
    }
}
