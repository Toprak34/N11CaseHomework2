package com.n11.pages;


import com.n11.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPageElement extends BasePageElement {

    @FindBy(className = "result-item")
    public WebElement resultText;

    @FindBy(css = "[content='TRY']")
    public List<WebElement> products;

    @FindBy(className = "seg-popup-close")
    public WebElement closePopUp;


    @FindBy(xpath = "//*[@class=\"pagination\"]/a[3]")
    public WebElement thirdPages;

    @FindBy(className = "product-add-cart")
    public WebElement addBasketButton;

    @FindBy(className = "btnGoBasket")
    public WebElement basketButton;


    WebDriver driver = Driver.get();

    public void selectProduct() {
        String actualUrl = Driver.get().getCurrentUrl();
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(products.get(0)).perform();

        products.get(0).click();
        addBasketButton.click();
        //closePopUp.click();
        driver.get(actualUrl);

        int sizeProduct = products.size() - 1;
        actions.moveToElement(products.get(sizeProduct)).perform();
        products.get(sizeProduct).click();
        addBasketButton.click();


        driver.get(actualUrl);
        thirdPages.click();
        actions.moveToElement(products.get(5)).perform();
        products.get(5).click();
        addBasketButton.click();

        basketButton.click();

    }


}
