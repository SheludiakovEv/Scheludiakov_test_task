import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import java.time.Duration;



public class LoginPageTest extends BaseTest {


    @Test
    public void incorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver,loginPage);
        loginPage.openPage();                                                           //открыл приложение
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));              //жду загрузки страницы
        loginPage.personalDate("test", "123");                        // ввод некорректных данных
        loginPage.clickLoginButton();                                                   //клик по кнопк Вход
        driver.findElement(By.xpath("//*[@id=\"error\"]")).isDisplayed();  //уведомление появилось
    }

    @Test
    public void loginByButtonAnotherAccount () {
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver,loginPage);
        loginPage.openPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage.personalDate("test2", "123");                         //ввод некорректного логина и пароля
        loginPage.clickLoginAnotherAccount();                                             //Клик по кнопке Вход (другая учетная запись)
        driver.findElement(By.xpath("//*[@id=\"error\"]")).isDisplayed();    //Уведомление появилось
    }

    @Test
    public void loginButtonCurrentAccount() {
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver,loginPage);
        loginPage.openPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage.personalDate("test3", "456");                        //ввод некорректного логина и пароля
        loginPage.clickLoginCurrentAccount();                                             //Клик по кнопке Вход (текущая учетная запись)
        driver.findElement(By.xpath("//*[@id=\"error\"]")).isDisplayed();    //Уведомление появилось
    }

    @Test
    public void zcorrectInput() {  //тест вход по корректному логину и паролю
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver,loginPage);
        loginPage.openPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage.personalDate("tester", "K35G3U");
        loginPage.clickCheckBox();
        loginPage.clickLoginButton();                                            //Клик по кнопке Вход
        driver.findElement(By.xpath("//*[@id=\"error\"]")).isDisplayed();    //Уведомление появилось
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));     //Ожидание пока грузится страница
        driver.findElement(By.id("userName")).isDisplayed();    //Проверка загрузски страницы
    }
}
