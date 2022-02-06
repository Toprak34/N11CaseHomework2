package com.n11.pages;

import com.n11.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasketPageElement extends BasePageElement {

    @FindBy(xpath = "(//*[@class=\"closeBtn\"])[3]")
    public WebElement closeMessage;

    @FindBy(name = "productDisplayPrice")
    public List<WebElement> productPrice;

    @FindBy(className = "spinnerUp")
    public List<WebElement> qtyUp;

    @FindBy(id = "js-buyBtn")
    public WebElement buyButton;

    @FindBy(className = "btn-continue")
    public WebElement continueButton;

    @FindBy(id = "guestEmail")
    public WebElement emailBtn;

    @FindBy(id ="js-guestEmailCheck")
    public WebElement continueEmailButton;

    @FindBy(id ="fullName")
    public WebElement customerName;

    @FindBy(id ="cityId")
    public WebElement cityName;

    @FindBy(id ="districtId")
    public WebElement districtName;

    @FindBy(id ="neighbourhoodId")
    public WebElement neighbourhoodName;

    @FindBy(id ="addressDetail")
    public WebElement addressDetailText;

    @FindBy(id ="gsm")
    public WebElement phoneNumberText;

    @FindBy(id ="shippingAddresstcNO")
    public WebElement customerTcNo;

    @FindBy(id ="addressName")
    public WebElement addressName;

    @FindBy(id="js-goToPaymentBtn")
    public WebElement goToPaymentButton;




    public void getCheapestProduct() throws InterruptedException {
        closeMessage.click();
        int cheapProduct=0;
        int cheapPrice = Integer.parseInt(productPrice.get(0).getAttribute("value"));
        for (int i = 0; i < productPrice.size(); i++) {

            int a = Integer.parseInt(productPrice.get(i).getAttribute("value"));

            if (a < cheapPrice) {
                cheapPrice = a;
                cheapProduct= i;
            }
        }

        Thread.sleep(2000);
        BrowserUtils.doubleClick(qtyUp.get(cheapProduct));

        Thread.sleep(4000);

    }

    public void continueAsGuest() throws InterruptedException {
        buyButton.click();
        BrowserUtils.waitForVisibility(continueButton, 10);
        continueButton.click();
        BrowserUtils.waitForVisibility(emailBtn, 10);
        emailBtn.sendKeys("abcdeneme1test123@gmail.com");
        continueEmailButton.click();
        customerName.sendKeys("hamza toprak");
        Select city = new Select(cityName);
        city.selectByVisibleText("İstanbul");
        Select district = new Select(districtName);
        district.selectByVisibleText("Bağcılar");
        Select neighbourhood = new Select(neighbourhoodName);
        neighbourhood.selectByVisibleText("Kirazlı");
        addressDetailText.sendKeys("kirazlı mahallesi");
        phoneNumberText.click();
        phoneNumberText.sendKeys("5539875613");
        customerTcNo.sendKeys("22582475038");
        addressName.sendKeys("ev");
        goToPaymentButton.click();

        Thread.sleep(3000);

    }
}
