import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
@RunWith(Parameterized.class)
public class OrderScooter {
    private final By button;
    private WebDriver driver;

    public OrderScooter(By button) {
        this.button = button;

    }

    @Parameterized.Parameters
    public static Object[] getInputData() {
        return new Object[]{
                By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[2]/button[1]"),
                By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div[2]/div[5]/button")
        };
    }

    @Before
    public void initialize() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void OrderTest() {

        MainPage objMainPage = new MainPage(driver);

        // кликни на кнопку Заказать
        objMainPage.clickOrderButton(button);// выбрать "UP" - Кнопка Заказать в верхнем правом углу."MID" - Кнопка заказать в центре страницы

        UserNameForOrder objForOrder = new UserNameForOrder(driver);// Выбор station из станций: "Бульвар Россоковского", "Чистые пруды", "Тёплый Стан", "Сокольники", "Красные Ворота"
        objForOrder.isTheScooterFor("Денис", "Тонконогов", "Москва", "Бульвар Россоковского", "+79999999999");

        RentInInfo objAboutRent = new RentInInfo(driver);
        objAboutRent.aboutRent("12.12.12", "1", "Black", "Нет комментария");

        HeaderWithTwoButtons objTwoButtons = new HeaderWithTwoButtons(driver);
        objTwoButtons.isTheScooterFor();

        OrderIsProcessed objIsProcessed = new OrderIsProcessed(driver);
        objIsProcessed.checkText();
    }

    @Test
    public void OrderTest1() {

        MainPage objMainPage = new MainPage(driver);

        // кликни на кнопку Заказать
        objMainPage.clickOrderButton(button);

        UserNameForOrder objForOrder = new UserNameForOrder(driver);// Выбор station из станций: "Бульвар Россоковского", "Чистые пруды", "Тёплый Стан", "Сокольники", "Красные Ворота"
        objForOrder.isTheScooterFor("Владимир", "Рыбин", "Владивосток", "Бульвар Россоковского", "+72345677654");

        RentInInfo objAboutRent = new RentInInfo(driver);
        objAboutRent.aboutRent("21.12.21", "5", "Grey", "Есть много комментариев");

        HeaderWithTwoButtons objTwoButtons = new HeaderWithTwoButtons(driver);
        objTwoButtons.isTheScooterFor();

        OrderIsProcessed objIsProcessed = new OrderIsProcessed(driver);
        objIsProcessed.checkText();
    }
    @After
    public void cleanUp() {

        driver.quit();
    }
}



