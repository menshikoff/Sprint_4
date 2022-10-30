package package_test;

import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.MainPage;

public class TestClass {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void StartDriver() throws InterruptedException {

        MainPage objMainPage = new MainPage(browserRule.getDriver());
        Thread.sleep(2_000);
        objMainPage.open().scrollToTheSectionFaq().pushQuestionPanelFromListOfQuestions(0);
        Thread.sleep(2_000);

        Assert.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                objMainPage.getTextOfAnswerOnQuestion(0));

//        if (objMainPage.getTextOfAnswerOnQuestion().equals("")) {
//            System.out.println("Данные отсутствуют ((");
//        }
//        else {
//            System.out.println("Есть данные!");
//        }

    }
}