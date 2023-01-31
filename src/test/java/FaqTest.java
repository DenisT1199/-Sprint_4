
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


@RunWith(Parameterized.class)
public class FaqTest {
    private WebDriver driver;

        private final By selectorQuestion;
        private final By selectorText;
        private final String expected;


        public FaqTest(By selectorQuestion, By selectorText, String expected) {
            this.selectorQuestion = selectorQuestion;
            this.selectorText = selectorText;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[] getAnswer() {
            return new Object[][]{
                    {By.xpath("//*[@id=\"accordion__heading-0\"]"),By.xpath("//*[@id=\"accordion__panel-0\"]/p"),"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    {By.xpath("//*[@id=\"accordion__heading-1\"]"),By.xpath("//*[@id=\"accordion__panel-1\"]/p"),"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                    {By.xpath("//*[@id=\"accordion__heading-2\"]"),By.xpath("//*[@id=\"accordion__panel-2\"]/p"),"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    {By.xpath("//*[@id=\"accordion__heading-3\"]"),By.xpath("//*[@id=\"accordion__panel-3\"]/p"),"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    {By.xpath("//*[@id=\"accordion__heading-4\"]"),By.xpath("//*[@id=\"accordion__panel-4\"]/p"),"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                    {By.xpath("//*[@id=\"accordion__heading-5\"]"),By.xpath("//*[@id=\"accordion__panel-5\"]/p"),"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                    {By.xpath("//*[@id=\"accordion__heading-6\"]"),By.xpath("//*[@id=\"accordion__panel-6\"]/p"),"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                    {By.xpath("//*[@id=\"accordion__heading-7\"]"),By.xpath("//*[@id=\"accordion__panel-7\"]/p"),"Да, обязательно. Всем самокатов! И Москве, и Московской области."}
            };
        }

        @Before
        public void initialize() {
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");

            WebElement element = driver.findElement(By.id("accordion__heading-7"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);//Скролл до нужного элемента

            driver.findElement(By.id("rcc-confirm-button")).click();// Закрыть всплывающее окно сообщающее про куки
        }

        @Test

        public void ComparisonTest() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, 2800);");
            wait.until((ExpectedConditions.visibilityOfElementLocated(selectorQuestion)));
            driver.findElement(selectorQuestion).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(selectorText));
            String actual = driver.findElement(selectorText).getText();
            Assert.assertEquals(actual, expected);
        }

    @After
    public void cleanUp() {
        driver.quit();
    }
}