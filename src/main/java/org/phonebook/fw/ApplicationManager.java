package org.phonebook.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.cssSelector;

public class ApplicationManager {
    WebDriver driver;

    UserHelper user;
    ContactHelper contact;
    HomePageHelper homaPage;

    public void init() {
        driver = new ChromeDriver(); //инициализация переменной
        driver.get("https://telranedu.web.app/"); //открытие сайта
        driver.manage().window().maximize(); //развернуть экран в полный размер именно на своем экране
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //время ожидания загрузки всех элементов

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        homaPage = new HomePageHelper(driver);

    }

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomePageHelper getHomaPage() {
        return homaPage;
    }

    public void stop() {
        driver.quit();// закрывает все окна, а close только одно
    }

    public boolean isContactAdded(String text) { // метод проверяет добавился ли контакт
        List<WebElement> contacts = (List<WebElement>) driver.findElement(cssSelector("h2"));
        for (WebElement el:contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;

    }

}
