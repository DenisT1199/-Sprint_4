import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderWithTwoButtons {
    private WebDriver driver;
    //
    private By questionYesButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]"); // нажать на кнопку Да

    public HeaderWithTwoButtons(WebDriver driver) {
        this.driver = driver;
    }
    public void questionYesButton() {
        driver.findElement(questionYesButton).click();
    }

    public void isTheScooterFor(){
        questionYesButton();


    }
}
