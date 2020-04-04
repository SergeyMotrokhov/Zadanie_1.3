package ru.yandexmarket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    String URL = "https://market.yandex.ru/";
    private WebDriver driver;
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
        driver.get(URL);
    }

    @FindBy(how = How.XPATH,using = ("//a[@href='/catalog--elektronika/54440']"))
    WebElement linkElectro;

    public ElektronikaPage clickElectro(){
        linkElectro.click();
        return new ElektronikaPage(driver);
    }
}
