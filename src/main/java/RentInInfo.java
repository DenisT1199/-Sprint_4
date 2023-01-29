import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentInInfo {
    private WebDriver driver;

    private By deliveryDateField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");// Поле когда привезти самокат
    private By listOfLeaseTermsButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/span");// Кнопка активации выпадающего окна для срока аренды
    private By choiceOfRentalPeriodButton1 = By.xpath("//html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]");// Выбор аренды на 1 сутки
    private By choiceOfRentalPeriodButton2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]");// Выбор аренды на 2 суток
    private By choiceOfRentalPeriodButton3 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]");// Выбор аренды на 3 суток
    private By choiceOfRentalPeriodButton4 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[4]");// Выбор аренды на 4 суток
    private By choiceOfRentalPeriodButton5 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[5]");// Выбор аренды на 5 суток
    private By choiceOfRentalPeriodButton6 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[6]");// Выбор аренды на 6 суток
    private By choiceOfRentalPeriodButton7 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[7]");// Выбор аренды на 7 суток





    private By colorSelectionButtonGrey = By.xpath("//*[@id=\"grey\"]"); // выбор чек-бокса серая безысходность
    private By colorSelectionButtonBlack = By.xpath("//*[@id=\"black\"]"); // выбор чек-бокса чёрный жемчуг
    private By deliveryCommentField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");// Поле для комментария
    private By toOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");// Кнопка Заказать


    public RentInInfo(WebDriver driver) {
        this.driver = driver;
    }
    public void deliveryDateField(String deliveryDate) {
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
    }
    public void listOfLeaseTermsButton() {
        driver.findElement(listOfLeaseTermsButton).click();
    }
    public  void choiceOfRentalPeriod(String number){
        if(number.equals("1")){// Выбор чек-бокса серая безысходность
            driver.findElement(choiceOfRentalPeriodButton1).click();
        }else if(number.equals("2")){// Выбор чек-бокса чёрный жемчуг
            driver.findElement(choiceOfRentalPeriodButton2).click();
        }else if(number.equals("3")){// Выбор чек-бокса чёрный жемчуг
            driver.findElement(choiceOfRentalPeriodButton3).click();
        }else if(number.equals("4")){// Выбор чек-бокса чёрный жемчуг
            driver.findElement(choiceOfRentalPeriodButton4).click();
        }else if(number.equals("5")){// Выбор чек-бокса чёрный жемчуг
            driver.findElement(choiceOfRentalPeriodButton5).click();
        }else if(number.equals("6")){// Выбор чек-бокса чёрный жемчуг
            driver.findElement(choiceOfRentalPeriodButton6).click();
        }else if(number.equals("7")){// Выбор чек-бокса чёрный жемчуг
            WebElement element = driver.findElement(choiceOfRentalPeriodButton7);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);// Нажать за кнопку Заказать в центральной части сайта.
            driver.findElement(choiceOfRentalPeriodButton7).click();
        }

    }

    public  void colorSelection(String color){
        if(color.equals("Grey")){// Выбор чек-бокса серая безысходность
            driver.findElement(colorSelectionButtonGrey).click();
        }else if(color.equals("Black")){// Выбор чек-бокса чёрный жемчуг
            driver.findElement(colorSelectionButtonBlack).click();
        }
    }


    public void deliveryCommentField(String deliveryComment) {
        driver.findElement(deliveryCommentField).sendKeys(deliveryComment);
    }
    public void toOrderButton() {
        driver.findElement(toOrderButton).click();
    }

    public void aboutRent(String deliveryDate,String number, String color, String deliveryComment){
        deliveryDateField(deliveryDate);
        listOfLeaseTermsButton();
        choiceOfRentalPeriod(number);
        colorSelection(color);
        deliveryCommentField(deliveryComment);
        toOrderButton();
    }
    }


