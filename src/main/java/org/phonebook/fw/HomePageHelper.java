package org.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HelperBase{
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.xpath("//h1[contains(.,'Home Component')]")).size()>0;//метод, который помогает найти элемент на странице по локатору и то что этот элемент хотя бы один
    }
}
