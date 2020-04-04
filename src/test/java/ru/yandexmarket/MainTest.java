package ru.yandexmarket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class MainTest extends WebDriverSettings {

    private void son(int s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void checkTitle(){
        System.out.println("checkTitle");
        MainPage mainPage=new MainPage(driver);
        String title = driver.getTitle();
        System.out.println(title);
        Assertions.assertTrue(title.contains("Яндекс.Маркет"));
    }

    @Test
    public void checkModel(){
        MainPage mainPage = new MainPage(driver);
        ElektronikaPage elektronikaPage = new ElektronikaPage(driver);
        MobilePhonePage mobilePhonePage = new MobilePhonePage(driver);
        mainPage.clickElectro();
        elektronikaPage.clickLinkMobilePhone();
        mobilePhonePage.clickCheckBox("Xiaomi");
        son(5000);
        boolean check = false;
        for (WebElement e: mobilePhonePage.getListOfWebElement())
            if(e.getText().equals("XIAOMI"))
                check=true;
        Assertions.assertTrue(check);
    }

}