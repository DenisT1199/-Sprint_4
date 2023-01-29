import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public  void clickOrderButton(String button){
        if(button.equals("UP")){
            driver.findElement(orderButton_UP).click();
        }else if(button.equals("MID")){
            WebElement element = driver.findElement(orderButton_MID);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);// Нажать за кнопку Заказать в центральной части сайта.
            driver.findElement(orderButton_MID).click();
        }
    }


   // public void waitForLoadProfileData() { //дождаться загрузки кнопки/загрузки
//
  //      new WebDriverWait(driver, 5).until(driver -> (driver.findElement(orderButton).getText() != null
    //            && !driver.findElement(orderButton).getText().isEmpty()
      //  ));
   // }
}


    