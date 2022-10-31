package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru";
    private final WebDriver driver;
    //Плашка с вопросом
    private By questionPanelFromListOfQuestions = By.className("accordion__heading");
    //Плашака с ответом
    private By answerPanelFromListOfQuestions = By.className("accordion__panel");
    //Верхняя кнопка заказа
    private By topOrderButton = By.className("Button_Button__ra12g");
    //Нижняя кнопка заказа
    private By middleOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //Лого "Самокат"
    private By logoSamokatOnMainPage = By.className("Header_LogoScooter__3lsAR");
    //Заголовок главной страницы
    private By headerMainPage = By.className("Home_Header__iJKdX");
    //Кнопка согласия на куки
    private By buttonAcceptCookies = By.id("rcc-confirm-button");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }
    public MainPage open() {
        driver.get(url);
        return this;
    }
    public MainPage scrollToTheSectionFaq() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        return this;
    }
    public void pushQuestionPanelFromListOfQuestions(int number) {
        driver.findElements(questionPanelFromListOfQuestions).get(number).click();
    }
    public String getTextOfAnswerOnQuestion(int number) {
        return driver.findElements(answerPanelFromListOfQuestions).get(number).getText();
    }
    public WebDriver openOrderForm(String button) {
        if (button.equals("top")) {
        driver.findElement(topOrderButton).click();}
        else {
            scrollToTheSectionFaq();
            driver.findElement(middleOrderButton).click();}
        return driver;
    }
    public void pushLogoSamokat() {
        driver.findElement(logoSamokatOnMainPage).click();
    }
    public boolean isMainPageVisible() {
        return driver.findElement(headerMainPage).isDisplayed();
    }
    public MainPage pushButtonAcceptCookies() {
        driver.findElement(buttonAcceptCookies).click();
        return this;
    }
}
