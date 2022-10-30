package package_test;

import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPage;

import java.time.Duration;

public class TestClickOnLogos {

    private final String buttonMakeOrder = "top";

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void testClickOnLogoSmokatLinkToMainPage() {
        MainPage objMainPage = new MainPage(browserRule.getDriver());
        objMainPage.open().openOrderForm(buttonMakeOrder);
        objMainPage.pushLogoSamokat();

        Assert.assertTrue(objMainPage.isMainPageVisible());

    }

}
