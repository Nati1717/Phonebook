package org.phonebook.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.cssSelector;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;//метод, который помогает найти 1 элемент на странице по локатору и то что этот элемент хотя бы один
    }

    public boolean isElementPresent2(By locator){ //универсальный метод
        try {
            driver.findElement(locator); // попробуй найти элемент
            return true;                 //если получилось, то ок
        } catch (NoSuchElementException ex) { //если не нашел, то такой элемент не найден
            return false;               //и возвращается не ок

        }

    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {

        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();   // очисти поле
            driver.findElement(locator).sendKeys(text); // введи данные логина
        }
    }

    public boolean isAlertPresent() { //есть ли окошко с ошибкой (alert)
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(40)). // class Alert, переменная alert, ждем 20 секунд определенного действия
                until(ExpectedConditions.alertIsPresent());// до появления окошка с ошибкой
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert(); // switchTo это перевод с главного окна в окно ошибки
            alert.accept(); //метод "accept" выполняет фуекцию клика на кнопку ок в окне уведомления об ошибке
            return true;
        }
    }

    public int pause (int millis) {
        try {
            Thread.sleep(millis);                               //метод,который подтормаживает систему, чтобы посчитать
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        public int sizeOfContacts()
        {                                //проверить количество этих карточек на странице
            if (isElementPresent(cssSelector(".contact-item_card__2SOIM"))) { //если эта карточка есть на странице
                return driver.findElements(cssSelector(".contact-item_card__2SOIM")).size();// то верни количество этих карточек
            }
            return 0;                                                 //если этой карточки нет, то верни ноль
        }

        public void addContact()
        {
            clickOnAddLink();
            fillContactForm(new Contact().
                    setName("Karl").
                    setSurname("Adam").
                    setPhone("1234567890").
                    setMail("Nati177Nati@gmail.com").
                    setAdress("Lindau").
                    setDeskription("boxer"));
            clickOnSaveButton();
        }

        public void login () {
            clickOnLoginLink();
            fillLoginRegistrationForm(new User().
                    setEmail("Nati177Nati@gmail.com").
                    setPassword("NatiNata17$"));
            clickOnLoginButton();  //и с помощью локатора кнопки login нажимаем на кнопку логин
        }
    }
}
