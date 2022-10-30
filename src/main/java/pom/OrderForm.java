package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OrderForm {

    private final WebDriver driver;
    private final By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    private final By familyNameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressDeliveryInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationInput = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By clientPhoneNumberInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonFurther = By.xpath(".//button[text()='Далее']");
    private final By deliveryDateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By numberOfDaysToRentInput = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By numberOfDaysToRentMenu =By.xpath(".//div[@class='Dropdown-menu']");
    private final By numberOfDaysToRentOption = By.xpath(".//div[@class='Dropdown-option']");
    private final By colourSamokatCheckBox = By.id("black");
    private final By buttonOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By buttonYesToConfirmOrder = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    private final By headerOrderIsComplete = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public OrderForm(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getHeaderOrderIsComplete() {
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(
                ExpectedConditions.presenceOfElementLocated(headerOrderIsComplete));
    }
    public void pushMetroStationInput() {
    driver.findElement(metroStationInput).click();
    }
    public void fillInName(String text) {
        driver.findElement(nameInput).sendKeys(text);
    }
    public void fillInFamilyName(String text) {
        driver.findElement(familyNameInput).sendKeys(text);
    }
    public void fillInAddressDelivery(String text) {
        driver.findElement(addressDeliveryInput).sendKeys(text);
    }
    public void fillInMetroStationName(String metroStationName) {
        pushMetroStationInput();
        driver.findElement(metroStationInput).sendKeys(metroStationName);
        new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.findElement(metroStationInput).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    public void fillInClientPhoneNumber(String text) {
        driver.findElement(clientPhoneNumberInput).sendKeys(text);
    }
    public void pushButtonFurther() {
        driver.findElement(buttonFurther).click();
    }
    public void fillInDeliveryDate() {
        Calendar date = new GregorianCalendar();
        date.add(Calendar.DAY_OF_MONTH, 3);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        driver.findElement(deliveryDateInput).sendKeys(formatter.format(date.getTime()), Keys.ENTER);
    }
    public void pushNumberOfDaysToRentInput() {
        driver.findElement(numberOfDaysToRentInput).click();
    }
    public void selectNumberOfDaysTORentOption() {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver ->
                driver.findElement(numberOfDaysToRentMenu).getAttribute("aria-expanded").equals("true"));
        driver.findElements(numberOfDaysToRentOption).get(2).click();
    }
    public void tickColourSamokatCheckBox() {
        driver.findElement(colourSamokatCheckBox).click();
    }
    public void pushButtonOrder() {
        driver.findElement(buttonOrder).click();
    }
    public void pushButtonYesToConfirmOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(
                driver.findElement(buttonYesToConfirmOrder))).click();
    }
}
