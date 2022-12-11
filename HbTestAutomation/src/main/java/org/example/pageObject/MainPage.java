package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//span[text()='Elektronik']")
    WebElement elektronikOption;

    @FindBy(xpath = ".//a[text()='Bilgisayar/Tablet']")
    WebElement bilgisayarTabletOption;

    @FindBy(xpath = ".//span[text()='Notebook']")
    WebElement notbookOption;


    @FindBy(xpath = ".//a[text()='Apple Dizüstü Bilgisayar Laptop']")
    WebElement appleCheckBox;

    @FindBy(xpath = ".//label[text()='Sıralama']")
    WebElement sıralamaCheckBox;

    @FindBy(xpath = ".//div[text()='Çok satanlar']")
    WebElement cokSatanlarOption;

    @FindBy(id = "shoppingCart")
    WebElement sepetimButton;

    @FindBy(id = "i1")
    WebElement secondUrun;

    @FindBy(xpath = ".//div[text()='Sepete ekle']")
    WebElement sepeteEkleButton;

    @FindBy(xpath = "//div[@id='markalar']//input[@placeholder='Filtrele']")
    WebElement filtreleTextBox;

//    @FindBy(id = "containerSelectorFocus")
//    WebElement frame;

    @FindBy(css = ".hb-toast-text")
    WebElement ürünEklendiMesajı;

    @FindBy(xpath = "//span[@class='active_3fZys']")
    WebElement sepettekiUrun;

    @FindBy(id = "continue_step_btn")
    WebElement alısverisiTamamlaButton;

    public void goToURL(WebDriver driver){

        this.driver.get("https://www.hepsiburada.com/");

    }

    public void clickNotebook() throws InterruptedException {

        Actions actions =new Actions(driver);


        actions.moveToElement(elektronikOption).build().perform();
        Thread.sleep(1000);
        actions.moveToElement(bilgisayarTabletOption).build().perform();
        Thread.sleep(1000);
        actions.moveToElement(notbookOption).click().build().perform();


    }

    public void scrollDown() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1300)");
        Thread.sleep(2000);


    }

    public void selectApple() throws InterruptedException {

        appleCheckBox.click();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        Thread.sleep(2000);



    }



    public void sıralama() throws InterruptedException {

        sıralamaCheckBox.click();
        Thread.sleep(1000);
        cokSatanlarOption.click();

        Thread.sleep(1000);
    }


    public void ürünEkleme() throws InterruptedException {
        Actions actions =new Actions(driver);
        actions.moveToElement(secondUrun).build().perform();

        sepeteEkleButton.click();
        Thread.sleep(1000);


    }

    public void mesaj() throws InterruptedException {
        Thread.sleep(2000);
        String textMesagge=  ürünEklendiMesajı.getText();
        System.out.println(textMesagge);


    }


    public void scrollUp() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1300)");
        Thread.sleep(2000);

    }

    public void goToCart() throws InterruptedException {

        sepetimButton.click();
        Thread.sleep(2000);

    }
    public void sepettekiUrunKontrol() throws InterruptedException {
        Thread.sleep(1500);
        String sepetText= sepettekiUrun.getText();
        if (sepetText.equals("SEÇİLEN ÜRÜNLER (1)")){
            System.out.println("Eklediğiniz ürün sepette mevcuttur!");
        }else {
            System.out.println("Eklediğiniz ürün sepette mevcut değildir!");
        }
    }


    public void alısverisiTamamla() throws InterruptedException {

        alısverisiTamamlaButton.click();
        Thread.sleep(3000);
        String üyeolTitle= driver.getTitle();
        String BeklenenTittle= "Üye Giriş Sayfası & Üye Ol - Hepsiburada";

        if (üyeolTitle.equals(BeklenenTittle)){
            System.out.println("Başarıyla login ekranına yönlendirilmiştir.");
        }else {
            System.out.println("Login ekranına yönlendirme başarısız!");
        }



    }





}
