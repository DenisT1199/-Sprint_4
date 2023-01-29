import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderIsProcessed {
    private static WebDriver driver;
    private By viewStatusButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button"); // Кнопка посмотреть заказ
    public OrderIsProcessed(WebDriver driver) {
        this.driver = driver;
    }
    public static void checkText() {//метод сравнивающий текст на копке ОР с ФР
        String unexpected = "Посмотреть статус";
        String actual = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[5]/div[2]")).getText();
        Assert.assertEquals(unexpected, actual);
    }
    public void viewStatusButton() {
        driver.findElement(viewStatusButton).click();
    }
    public void theСonfirmation(){
        viewStatusButton();


    }
}
