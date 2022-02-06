package com.n11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PaymentPageElement extends BasePageElement {

    @FindBy(className = "cardNumberInput")
    public WebElement creditCardNo;

    @FindBy(id = "cardOwnerName")
    public WebElement creditCardName;

    @FindBy(id = "expireMonth")
    public WebElement creditCartMonth;

    @FindBy(id = "expireYear")
    public WebElement creditCardYear;

    @FindBy(id = "securityCode")
    public WebElement creditCardSecureCode;

    @FindBy(id = "js-paymentBtn")
    public WebElement makePaymentButton;

    @FindBy(className = "errorText")
    public WebElement errorText;


    public void makePayment(){

        creditCardNo.sendKeys("123");
        creditCardName.sendKeys("Hamza Toprak");
        Select month = new Select(creditCartMonth);
        month.selectByVisibleText("5");
        Select year = new Select(creditCardYear);
        year.selectByVisibleText("2023");
        creditCardSecureCode.sendKeys("134");
        makePaymentButton.click();

    }


}
