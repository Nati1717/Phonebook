package org.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod // мы убеждаемся, что наш пользователь разлогинен, это предусловие
    public void ensurePrecondition() {
        if (app.getUser().isLoginLinkPresent()) {       // если ты не найдешь кнопку Login (используем локатор Логина)
            app.getUser().clickOnSignOut();
        }
        app.getUser().login();

        app.getContact().addContact();

        app.click(By.cssSelector("[href='/add']"));// нашли по локатору кнопку ADD и кликнули по ней
        app.type(By.cssSelector("input:child(1)"), "Karl"); // нашли по локатору первой поле формы и заполнили его именем
        app.type(By.cssSelector("input:child(2)"), "Adam"); // нашли по локатору первой поле формы и заполнили его фамилией
        app.type(By.cssSelector("input:child(3)"), "456178906543"); // нашли по локатору первой поле формы и заполнили его телефоном
        app.type(By.cssSelector("input:child(4)"), "adam@gmail.com"); // нашли по локатору первой поле формы и заполнили его E-Mail
        app.type(By.cssSelector("input:child(5)"), "Lindau"); // нашли по локатору первой поле формы и заполнили его адресом
        app.type(By.cssSelector("input:child(6)"), "boxer"); // нашли по локатору первой поле формы и заполнили его

        app.click(By.cssSelector(".add_form__2rsm2 button")); // клик на кнопку сохранить
    }

    @Test

    public void removeContactPositiveTest() {                   //удаление карточки
        int sizeBefore = app.getContact().sizeOfContacts();                      // количество карточек еще до проверки
        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();                        // количество карточек уже после удаления карточки

        Assert.assertEquals(sizeAfter, sizeBefore-1);    // сравнение количества карточек до и после проверки
    }

}
