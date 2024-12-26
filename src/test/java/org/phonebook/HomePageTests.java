package org.phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase { // наследник класса TestBase

    @Test
    public void isHomeComponentPresentTest() { //поиск компонента, если этот компонент на странице
        //driver.findElement(By.xpath("//h1[text()='Home Component']")); //поиск по текстовому локатору
        //isHomeComponentPresent(); // или System.out/println ("Home Component" +isHomeComponentPresent()); чтобы проверить точно, что он есть
        //System.out.println("Home Component is" + isElementPresent (By.xpath("//h1[contains(.,'Home Component')]")));
        Assert.assertTrue(isHomeComponentPresent()); //класс, который сравнивает ожидаемый и действительный результаты, ожидается один локатор, а получается либо правильный , либо нет
    }


}
