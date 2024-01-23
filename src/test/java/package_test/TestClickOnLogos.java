package package_test;

import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;

public class TestClickOnLogos {

    private final String buttonMakeOrder = "top";

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void testClickOnLogoSamokatLinkToMainPage() {
        MainPage objMainPage = new MainPage(browserRule.getDriver());
        objMainPage
                .open()
                .pushButtonAcceptCookies()
                .openOrderForm(buttonMakeOrder);

        objMainPage.pushLogoSamokat();

        Assert.assertTrue(objMainPage.isMainPageVisible());

    }

}
