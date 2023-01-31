import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private By orderButton_UP = By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[2]/button[1]");//Кнока "Заказать" в верхей - правой части сайта.
    private By orderButton_MID = By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div[2]/div[5]/button"); // Кнопка "Заказать" в центральной части сайта.

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton() { // Нажать за кнопку Заказать в верхей - правой части сайта.
        driver.findElement(orderButton_UP).click();
    }

    public void clickOrderButton2() {
        WebElement element = driver.findElement(orderButton_MID);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);// Нажать за кнопку Заказать в центральной части сайта.
        driver.findElement(orderButton_MID).click();
    }

    public By clickOrderButton(By button) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element = driver.findElement(button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(button).click();
        return button;
    }

}



