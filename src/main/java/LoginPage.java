import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LoginPage {

    @FindBy(id = "username")
    private WebElement fieldNumber; //Локатор поля ввода номера телефона

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement fieldPassword; //Локатор поля ввода пароля

    @FindBy(xpath = "//*[@id=\"login_form\"]/div[1]/div[4]/label")
    private WebElement checkBox;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div[1]/div[4]/label")
    private WebElement checkboxRememberMe; //Локатор чек-бокс Запомнить меня

    @FindBy(xpath = "//*[@id=\"login_button\"]")
    private WebElement loginButton; //Локатор кнопки входа

    @FindBy(id = "login_button_domain")
    private WebElement buttonSignInAnotherAccount; //Локатор кнопки входа другой учетной записи

    @FindBy(id = "login_button_current")
    private WebElement loginButtonCurrentAccount; //Локтор кнопки входа текуш=щей учетной записи

    public String invalidPasswordTest = "Неверное имя пользователя или пароль";
   public LoginPage(WebDriver driver) {
       this.driver = driver;
   }

    private WebDriver driver;

    public void openPage() {   //Открываем ссылку приложения
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("https://release-17.gdcloud.org");
    }

    public void setUserName(String surname) { //Ввод номера
        fieldNumber.sendKeys(surname);
    }

    public void setPassword(String surpassword) { //Ввод пароля
        fieldPassword.sendKeys(surpassword);
    }

    public void clickLoginButton() { //Клик по кнопке Входа
        loginButton.click();
    }

    public void clickLoginAnotherAccount() { //Клик по кнопке Вход (другая учетная запись)
        buttonSignInAnotherAccount.click();
    }

    public void clickLoginCurrentAccount() {  //Клик по кнопке Вход (текущая учетная запись)
        loginButtonCurrentAccount.click();
    }

    public void clickCheckBox() {
        checkBox.click();
    }

    public void personalDate(String surname, String surpasword) {  //Метод ввода данных в поля имя и пароль
        setUserName(surname);
        setPassword(surpasword);
    }





}