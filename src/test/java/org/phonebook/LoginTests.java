package org.phonebook;

import org.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @BeforeMethod // мы убеждаемся, что наш пользователь разлогинен, это предусловие
    public void ensurePrecondition() {
        if (app.getUser().isLoginLinkPresent()) {       // если ты не найдешь кнопку Login (используем локатор Логина)
            app.getUser().clickOnSignOut();
        }
        app.getUser().clickOnLoginLink();
    }


    //ЗАЛОГИНИТЬСЯ
    @Test
    public void loginPositiveTest() {
        app.getUser().fillLoginRegistrationForm(new User().
                setEmail("Nati177Nati@gmail.com").
                setPassword("NatiNata17$"));
        app.getUser().clickOnLoginButton(); //метод "click", который заменяет isFindElement
                                                            //и с помощью локатора кнопки login
                                                            //нажимаем на кнопку логин
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.fillLoginRegistrationForm(new User().
                setPassword("NatiNata17$"));
        app.clickOnLoginButton(); //метод "click", который заменяет isFindElement
                                                            //и с помощью локатора кнопки login
                                                            //нажимаем на кнопку логин
        Assert.assertTrue(app.isAlertPresent());
    }


}
