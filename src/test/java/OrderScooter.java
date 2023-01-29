import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrderScooter {
    private WebDriver driver;

    @Test
    public void OrderTest() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        // дождись загрузки данных профиля на главной странице
        //  objMainPage.waitForLoadProfileData();

        // кликни на кнопку Заказать
        objMainPage.clickOrderButton("UP");// выбрать "UP" - Кнопка Заказать в верхнем правом углу."MID" - Кнопка заказать в центре страницы

        UserNameForOrder objForOrder = new UserNameForOrder(driver);// Выбор station из станций: "Бульвар Россоковского", "Чистые пруды", "Тёплый Стан", "Сокольники", "Красные Ворота"
        objForOrder.isTheScooterFor("Денис","Тонконогов","Москва", "Бульвар Россоковского","+79999999999");

        RentInInfo objAboutRent = new RentInInfo(driver);
        objAboutRent.aboutRent("12.12.12", "1","Black","Нет комментария");

        HeaderWithTwoButtons objTwoButtons = new HeaderWithTwoButtons(driver);
        objTwoButtons.isTheScooterFor();

        OrderIsProcessed objIsProcessed = new  OrderIsProcessed(driver);
        objIsProcessed.checkText();

    }
    @After
    public void cleanUp(){

        driver.quit();
    }
    @Test
    public void OrderTest3() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
// дождись загрузки данных профиля на главной странице
        //  objMainPage.waitForLoadProfileData();

        // кликни на кнопку Заказать
        objMainPage.clickOrderButton("MID");// выбрать "UP" - Кнопка Заказать в верхнем правом углу."MID" - Кнопка заказать в центре страницы

        UserNameForOrder objForOrder = new UserNameForOrder(driver);// Выбор station из станций: "Бульвар Россоковского", "Чистые пруды", "Тёплый Стан", "Сокольники", "Красные Ворота"
        objForOrder.isTheScooterFor("Стас","Белов","Сызрань", "Чистые пруды","+78888888888");

        RentInInfo objAboutRent = new RentInInfo(driver);
        objAboutRent.aboutRent("21.12.21", "3","Grey","Меня нет дома");

        HeaderWithTwoButtons objTwoButtons = new HeaderWithTwoButtons(driver);
        objTwoButtons.isTheScooterFor();

        OrderIsProcessed objIsProcessed = new  OrderIsProcessed(driver);
        objIsProcessed.checkText();

    }
    @After
    public void cleanUp3(){

        driver.quit();
    }


    @Test
    public void OrderTest2() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
// дождись загрузки данных профиля на главной странице
        //  objMainPage.waitForLoadProfileData();

        // кликни на кнопку редактирования профиля
        objMainPage.clickOrderButton("MID");// выбрать "UP" - Кнопка Заказать в верхнем правом углу."MID" - Кнопка заказать в центре страницы

        UserNameForOrder objForOrder = new UserNameForOrder(driver);// Выбор station из станций: "Бульвар Россоковского", "Чистые пруды", "Тёплый Стан", "Сокольники", "Красные Ворота"
        objForOrder.isTheScooterFor("Денис","Тонконогов","Москва", "Чистые пруды","+79999999999");

        RentInInfo objAboutRent = new RentInInfo(driver);
        objAboutRent.aboutRent("12.12.12", "7","Black","Нет комментария");

        HeaderWithTwoButtons objTwoButtons = new HeaderWithTwoButtons(driver);
        objTwoButtons.isTheScooterFor();

        OrderIsProcessed objIsProcessed = new  OrderIsProcessed(driver);
        objIsProcessed.checkText();


    }
    @After
    public void cleanUp1(){

        driver.quit();
    }
    @Test
    public void OrderTest4() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
// дождись загрузки данных профиля на главной странице
        //  objMainPage.waitForLoadProfileData();

        // кликни на кнопку редактирования профиля
        objMainPage.clickOrderButton("UP");// выбрать "UP" - Кнопка Заказать в верхнем правом углу."MID" - Кнопка заказать в центре страницы

        UserNameForOrder objForOrder = new UserNameForOrder(driver);// Выбор station из станций: "Бульвар Россоковского", "Чистые пруды", "Тёплый Стан", "Сокольники", "Красные Ворота"
        objForOrder.isTheScooterFor("Айзек","Азимов","Владивосток", "Тёплый Стан", "+75555555555");

        RentInInfo objAboutRent = new RentInInfo(driver);
        objAboutRent.aboutRent("12.12.12", "5","Grey", "Нет комментария");

        HeaderWithTwoButtons objTwoButtons = new HeaderWithTwoButtons(driver);
        objTwoButtons.isTheScooterFor();

        OrderIsProcessed objIsProcessed = new  OrderIsProcessed(driver);
        objIsProcessed.checkText();


    }
    @After
    public void cleanUp4(){

        driver.quit();
    }
}
