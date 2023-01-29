import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserNameForOrder {
    private WebDriver driver;
    private By firstNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");// Поле Имя
    private By secondNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");//Поле Фамилия
    private By streetNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");//Поле Адрес
    private By metroNameButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");//Выпадающий список метро
    private By stationNameButton1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]");//Выбор станции Бульвар Россоковского
    private By stationNameButton4 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[4]");//Выбор станции Бульвар Россоковс
    private By stationNameButton7 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[7]");//Выбор станции Бульвар Россоковс
    private By stationNameButton8 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[8]");//Выбор станции Бульвар Россоковс
    private By stationNameButton101 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[101]");//Выбор станции Тёплый Стан

    private By phoneNumberField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");//Поле помер телефона
    private By nextForOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");//Кнопка Далее

    public UserNameForOrder(WebDriver driver) {
        this.driver = driver;
    }
    public void setFirstNameField(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setSecondNameField(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }

    public void setStreetNameField(String streetName) {
        driver.findElement(streetNameField).sendKeys(streetName);
    }

    public void clickMetroNameButton() {
        driver.findElement(metroNameButton).click();
    }

    public  void choiceOfMetroStation(String Station){
        if(Station.equals("Бульвар Россоковского")){//
            driver.findElement(stationNameButton1).click();
        }else if(Station.equals("Сокольники")){//
            driver.findElement(stationNameButton4).click();
        }else if(Station.equals("Красные Ворота")){//
            driver.findElement(stationNameButton7).click();
        }else if(Station.equals("Чистые пруды")){//
            WebElement element = driver.findElement(stationNameButton8);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);//
            driver.findElement(stationNameButton8).click();
        }else if(Station.equals("Тёплый Стан")){//
            WebElement element = driver.findElement(stationNameButton101);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);//
            driver.findElement(stationNameButton101).click();
        }

    }

    public void setPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickNextForOrderButton() {
        driver.findElement(nextForOrderButton).click();
    }
    public void isTheScooterFor(String firstName, String secondName, String streetName,String Station, String phoneNumber){
        setFirstNameField(firstName);
        setSecondNameField(secondName);
        setStreetNameField(streetName);
        clickMetroNameButton();
        //new WebDriverWait(driver,10);
        choiceOfMetroStation(Station);
        setPhoneNumberField(phoneNumber);
        clickNextForOrderButton();

    }

}
