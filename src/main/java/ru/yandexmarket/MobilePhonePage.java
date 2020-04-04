package ru.yandexmarket;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.String.format;

public class MobilePhonePage {
    String URL = "https://market.yandex.ru/catalog--mobilnye-telefony-v-penze/54726/list?hid=91491";
    private WebDriver driver;
    String model;
    private int count;

    public MobilePhonePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        //driver.get(URL);
    }

    private String checkBox = "//*[text()='%s']/ancestor::*[@class='LhMupC0dLR']";

    @FindBy(how = How.XPATH, using = ("//*[@class='n-snippet-cell2__brand-name']"))
    List<WebElement> listOfWebElement;

    @FindBy (how = How.XPATH, using = ("//span[text()='Вперед']/ancestor::a"))
    WebElement pageGo;


    public void clickCheckBox(String model) {
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(By.xpath(format(checkBox, model)))).click();
        count=1;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (count<=10){
            if (pageGo.isDisplayed()) {
                try {
                    pageGo.click();
                    count++;
                }catch (WebDriverException e){
                    break;
                }
            }else{
                try {
                    System.out.println();
                    break;
                }catch (NoSuchElementException f){
                    break;
                }
                }
            }
        }

        public List<WebElement> getListOfWebElement() {
             return listOfWebElement;
        }

    }
