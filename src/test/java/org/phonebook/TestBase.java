package org.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeMethod

    public void setUp() {
        driver = new ChromeDriver(); //инициализация переменной
        driver.get("https://telranedu.web.app/"); //открытие сайта
        driver.manage().window().maximize(); //развернуть экран в полный размер именно на своем экране
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //время ожидания загрузки всех элементов
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.xpath("//h1[contains(.,'Home Component')]")).size()>0;//метод, который помогает найти элемент на странице по локатору и то что этот элемент хотя бы один
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

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();// закрывает все окна, а close только одно
    }
}
