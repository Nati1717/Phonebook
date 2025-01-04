package org.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.phonebook.models.Contact;

import static org.openqa.selenium.By.cssSelector;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddLink() {
        click(cssSelector("[href='/add']"));
    }

    public void clickOnSaveButton() {
        click(cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(Contact contact) {
        type(cssSelector("input:child(1)"), contact.getName()); // нашли по локатору первой поле формы и заполнили его именем
        type(cssSelector("input:child(2)"), contact.getSurname()); // нашли по локатору первой поле формы и заполнили его фамилией
        type(cssSelector("input:child(3)"), contact.getPhone()); // нашли по локатору первой поле формы и заполнили его телефоном
        type(cssSelector("input:child(4)"), contact.getMail()); // нашли по локатору первой поле формы и заполнили его E-Mail
        type(cssSelector("input:child(5)"), contact.getAdress()); // нашли по локатору первой поле формы и заполнили его адресом
        type(cssSelector("input:child(6)"), contact.getDeskription()); // нашли по локатору первой поле формы и заполнили его
    }

    public void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }
}
