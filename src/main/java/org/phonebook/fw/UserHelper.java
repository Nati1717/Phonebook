package org.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.phonebook.models.User;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("a:nth-child(4)"));
    }

    public void clickOnSignOut() {
        click(By.xpath("//button[contains(.,'Sign out')]"));
    }

    public boolean isLoginLinkPresent() {

        return !isElementPresent(By.xpath("//a[.='LOGIN'"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    protected boolean isSignOutButtonPresent() {
        return isSignOutButtonPresent();
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[.='Login']"));
    }
}
