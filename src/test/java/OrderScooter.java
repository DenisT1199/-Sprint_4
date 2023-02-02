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
    private final String deliveryDate;
    private final String number;
    private final String color;
    private final String deliveryComment;
    private final String firstName;
    private final String secondName;
    private final String streetName;
    private final String Station;
    private final String phoneNumber;
    private final By button;
    private WebDriver driver;

    public OrderScooter(By button, String firstName, String secondName, String streetName,String Station, String phoneNumber, String deliveryDate,String number, String color, String deliveryComment) {
        this.button = button;
        this.firstName = firstName;
        this.secondName = secondName;
        this.streetName = streetName;
        this.Station = Station;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.number = number;
        this.color = color;
        this.deliveryComment = deliveryComment;
    }

    @Parameterized.Parameters
    public static Object[] getInputData() {
        return new Object[][]{
                {By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[2]/button[1]"), "Владимир", "Рыбин", "Владивосток", "Бульвар Россоковского", "+72345677654", "12.12.12", "1", "Grey", "Нет комментариев"},
                {By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div[2]/div[5]/button"), "Денис", "Тонконогов", "Москва", "Бульвар Россоковского", "+77777777777", "21.12.21", "7", "Black", "Скорее бы привезли"}
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
        objForOrder.isTheScooterFor(firstName, secondName, streetName, Station, phoneNumber);

        RentInInfo objAboutRent = new RentInInfo(driver);
        objAboutRent.aboutRent(deliveryDate, number, color, deliveryComment);

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



