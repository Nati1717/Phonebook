package org.phonebook;

import org.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod // мы убеждаемся, что наш пользователь разлогинен, это предусловие
    public void ensurePrecondition() {
        if (app.getUser().isLoginLinkPresent()) {       // если ты не найдешь кнопку Login (используем локатор Логина)
            app.getUser().clickOnSignOut();
        }
        app.getUser().clickOnLoginLink();

    }


    //РЕГИСТРАЦИЯ НОВОГО ПОЛЬЗОВАТЕЛЯ
    @Test
    //public void newUserRegistrationPositiveTest() {
        //driver.findElement(By.cssSelector("[placeholder='Email']")).click();   // используя локатор поля для регистрации введения логина кликни на поле
        //driver.findElement(By.cssSelector("[placeholder='Email']")).clear();   // очисти поле
        //driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("Nati177@gmail.com"); // введи данные логина


        //driver.findElement(By.cssSelector("[placeholder='Password']")).click(); //с помощью локатора поля пароля кликни на поле пароля
        //driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        //driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("NatiNata17$");
       // driver.findElement(By.xpath("//button[text()='Registration']")).click(); //находим кнопку регистрации и кликаем
        //Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign out')]")));  // проверяем что есть кнопка Sign out

    //}


    public void existedUserRegistrationNegativeTest() {
        app.getUser().fillLoginRegistrationForm(new User().
                setEmail("Nati177Nati@gmail.com").
                setPassword("NatiNata17$"));
        app.getUser().clickOnRegistrationButton(); //находим кнопку регистрации и кликаем
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @AfterMethod
    public void postCondition (){
        app.getContact().removeContact();
    }
}


