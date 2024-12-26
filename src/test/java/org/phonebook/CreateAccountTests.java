package org.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod // мы убеждаемся, что наш пользователь разлогинен, это предусловие
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("a:nth-child(4)"))) {       // если ты не найдешь кнопку Login (используем локатор Логина)
            driver.findElement(By.xpath("//button[contains(.,'Sign out')]")).click();   // то найди кнопку Sign out и кликни
        }
        driver.findElement(By.cssSelector("a:nth-child(4)")).click(); // найди кнопку Login и кликни на нее

    }

    @Test
    public void newUserRegistrationPositiveTest(){
        driver.findElement(By.cssSelector("[placeholder='Email']")).click();   // используя локатор поля для регистрации введения логина кликни на поле
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();   // очисти поле
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("Nati177@gmail.com"); // введи данные логина


        driver.findElement(By.cssSelector("[placeholder='Password']")).click(); //с помощью локатора поля пароля кликни на поле пароля
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("NatiNata17$");
        driver.findElement(By.xpath("//button[text()='Registration']")).click(); //находим кнопку регистрации и кликаем
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign out')]")));  // проверяем что есть кнопка Sign out

    }




}


