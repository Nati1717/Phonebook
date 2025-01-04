package org.phonebook;

import org.phonebook.models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.cssSelector;

public class AddContactTests extends TestBase{

    @BeforeMethod // мы убеждаемся, что наш пользователь разлогинен, это предусловие
    public void ensurePrecondition() {
        if (!app.getUser().isElementPresent(cssSelector("a:nth-child(4)"))) {       // если ты не найдешь кнопку Login (используем локатор Логина)
            app.getUser().clickOnSignOut();
        }
        app.getUser().click(cssSelector("a:nth-child(4)"));

        app.getUser().type(cssSelector("[placeholder='Email']"), "Nati177Nati@gmail.com");
        app.getUser().type(cssSelector("[placeholder='Password']"), "NatiNata17$");
        app.getUser().clickOnLoginButton();
        //и с помощью локатора кнопки login
        //нажимаем на кнопку логин
        app.getContact().clickOnAddLink();// нашли по локатору кнопку ADD и кликнули по ней
    }

    @Test
    public void addContactPositiveTest () {
        app.getContact().fillContactForm(new Contact().
                setName("Karl").
                setSurname("Adam").
                setPhone("456178906543")
                .setMail("adam@gmail.com").
                setMail("Lindau").
                setDeskription("boxer"));

        app.getContact().clickOnSaveButton(); // клик на кнопку сохранить
        Assert.assertTrue(app.getContact().isContactAdded("Karl"));
    }

    @AfterMethod
    public void  postCondition(){       //чистка аккаунта после добавления контакта
        app.removeContact();

    }

}
