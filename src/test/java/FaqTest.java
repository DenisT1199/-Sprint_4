import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FaqTest {



    private static final By QUESTIONS_ABOUT_IMPORTANT_1 = By.id("accordion__heading-0");
    private static final By QUESTIONS_ABOUT_IMPORTANT_2 = By.id("accordion__heading-1");
    private static final By QUESTIONS_ABOUT_IMPORTANT_3 = By.id("accordion__heading-2");
    private static final By QUESTIONS_ABOUT_IMPORTANT_4 = By.id("accordion__heading-3");
    private static final By QUESTIONS_ABOUT_IMPORTANT_5 = By.id("accordion__heading-4");
    private static final By QUESTIONS_ABOUT_IMPORTANT_6 = By.id("accordion__heading-5");
    private static final By QUESTIONS_ABOUT_IMPORTANT_7 = By.id("accordion__heading-6");
    private static final By QUESTIONS_ABOUT_IMPORTANT_8 = By.id("accordion__heading-7");
    private WebDriver driver;

    @Test
    public void checkText() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);//Скролл до нужного элемента

        driver.findElement(By.id("rcc-confirm-button")).click();// Закрыть всплывающее окно сообщающее про куки


        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_1).click();
        String unexpected1  = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual1  = driver.findElement(By.id("accordion__panel-0")).getText();
        Assert.assertEquals(unexpected1, actual1);//Проверка первого раздела

        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_2).click();
        String unexpected2  = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actual2  = driver.findElement(By.id("accordion__panel-1")).getText();
        Assert.assertEquals(unexpected2, actual2);//Проверка второго раздела

        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_3).click();
        String unexpected3  = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actual3  = driver.findElement(By.id("accordion__panel-2")).getText();
        Assert.assertEquals(unexpected3, actual3);//Проверка третьего раздела

        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_4).click();
        String unexpected4  = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actual4  = driver.findElement(By.id("accordion__panel-3")).getText();
        Assert.assertEquals(unexpected4, actual4);//Проверка четвертого раздела

        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_5).click();
        String unexpected5  = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actual5  = driver.findElement(By.id("accordion__panel-4")).getText();
        Assert.assertEquals(unexpected5, actual5);//Проверка пятого раздела

        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_6).click();
        String unexpected6  = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actual6  = driver.findElement(By.id("accordion__panel-5")).getText();
        Assert.assertEquals(unexpected6, actual6);//Проверка шестого раздела

        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_7).click();
        String unexpected7  = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actual7  = driver.findElement(By.id("accordion__panel-6")).getText();
        Assert.assertEquals(unexpected7, actual7);//Проверка седьмого раздела


        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_8).click();
        String unexpected8  = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actual8  = driver.findElement(By.id("accordion__panel-7")).getText();
        Assert.assertEquals(unexpected8, actual8);//Проверка влсьмого раздела

        }

@After
    public void cleanUp(){

        driver.quit();
}
    @Test
    public void checkText2() {

        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);//Скролл до нужного элемента

        driver.findElement(By.id("rcc-confirm-button")).click();// Закрыть всплывающее окно сообщающее про куки


        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_1).click();
        String unexpected1  = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual1  = driver.findElement(By.id("accordion__panel-0")).getText();
        Assert.assertEquals(unexpected1, actual1);//Проверка первого раздела

        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_2).click();
        String unexpected2  = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actual2  = driver.findElement(By.id("accordion__panel-1")).getText();
        Assert.assertEquals(unexpected2, actual2);//Проверка второго раздела

        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_3).click();
        String unexpected3  = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actual3  = driver.findElement(By.id("accordion__panel-2")).getText();
        Assert.assertEquals(unexpected3, actual3);//Проверка третьего раздела

        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_4).click();
        String unexpected4  = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actual4  = driver.findElement(By.id("accordion__panel-3")).getText();
        Assert.assertEquals(unexpected4, actual4);//Проверка четвертого раздела

        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_5).click();
        String unexpected5  = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actual5  = driver.findElement(By.id("accordion__panel-4")).getText();
        Assert.assertEquals(unexpected5, actual5);//Проверка пятого раздела

        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_6).click();
        String unexpected6  = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actual6  = driver.findElement(By.id("accordion__panel-5")).getText();
        Assert.assertEquals(unexpected6, actual6);//Проверка шестого раздела

        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_7).click();
        String unexpected7  = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actual7  = driver.findElement(By.id("accordion__panel-6")).getText();
        Assert.assertEquals(unexpected7, actual7);//Проверка седьмого раздела


        driver.findElement(QUESTIONS_ABOUT_IMPORTANT_8).click();
        String unexpected8  = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actual8  = driver.findElement(By.id("accordion__panel-7")).getText();
        Assert.assertEquals(unexpected8, actual8);//Проверка влсьмого раздела

    }

    @After
    public void cleanUp2(){

        driver.quit();
    }
}

