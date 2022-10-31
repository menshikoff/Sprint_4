package package_test;

import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pom.MainPage;
import pom.OrderForm;

@RunWith(Parameterized.class)
public class TestCorrectnessOfOderPlacement {
    private final String buttonMakeOrder;
    private final String clientName;
    private final String clientFamilyName;
    private final String clientAddress;
    private final String clientPhoneNumber;
    private final String clientMetroStation;
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    public TestCorrectnessOfOderPlacement(String buttonMakeOrder,
                                          String clientName,
                                          String clientFamilyName,
                                          String clientAddress,
                                          String clientPhoneNumber,
                                          String clientMetroStation) {
        this.buttonMakeOrder = buttonMakeOrder;
        this.clientName = clientName;
        this.clientFamilyName = clientFamilyName;
        this.clientAddress = clientAddress;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientMetroStation = clientMetroStation;
    }

    @Parameterized.Parameters
    public static Object[][] getParametersForTestOrderPlacement() {
        return new Object[][]{
                {"top", "Даниил", "Меньшиков", "Москва, Красная площадь", "89851231111", "Бульвар Рокосовского"},
                {"mid", "Наталья", "Меньшикова", "Москва, ул. Арбат", "89211231122", "Черемушки"},
        };
    }

    @Test
    public void testOderPlacementFunction() {
        MainPage objMainPage = new MainPage(browserRule.getDriver());
        OrderForm objOrderForm = new OrderForm(objMainPage.open().pushButtonAcceptCookies()
                                                                    .openOrderForm(buttonMakeOrder));
        //Заполняет раздел "Для кого самокат"
        objOrderForm.fillInName(clientName);
        objOrderForm.fillInFamilyName(clientFamilyName);
        objOrderForm.fillInAddressDelivery(clientAddress);
        objOrderForm.fillInClientPhoneNumber(clientPhoneNumber);
        objOrderForm.fillInMetroStationName(clientMetroStation);
        objOrderForm.pushButtonFurther();

        //Заполняет раздел "Про аренду"
        objOrderForm.fillInDeliveryDate();
        objOrderForm.pushNumberOfDaysToRentInput();
        objOrderForm.selectNumberOfDaysTORentOption();
        objOrderForm.tickColourSamokatCheckBox();
        objOrderForm.pushButtonOrder();
        objOrderForm.pushButtonYesToConfirmOrder();

        Assert.assertTrue(objOrderForm.getHeaderOrderIsComplete().getText().contains("Заказ оформлен"));

    }

}
