package com.n11.step_definitions;

import com.n11.pages.BasePageElement;
import com.n11.pages.BasketPageElement;
import com.n11.pages.PaymentPageElement;
import com.n11.pages.SearchPageElement;
import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class N11StepDef {
    WebDriver driver= Driver.get();
    BasePageElement basePageElement = new BasePageElement();
    SearchPageElement searchPage=new SearchPageElement();
    BasketPageElement basketPage=new BasketPageElement();
    PaymentPageElement paymentPage=new PaymentPageElement();

    @Given("User go to home page and search {string}")
    public void userGoToHomePageAndSearch(String product){
        driver.get(ConfigurationReader.get("url"));
        basePageElement.searchProduct(product);
        searchPage.selectProduct();
        // searchPage.otherPage("3");

    }

    @When("user adds product to basket")
    public void user_adds_product_to_basket() throws InterruptedException {
        basketPage.getCheapestProduct();
        basketPage.continueAsGuest();
    }


    @Then("user pays with wrong credit card number")
    public void userPaysWithWrongCreditCardNumber() throws InterruptedException {
        paymentPage.makePayment();
        Assert.assertTrue(paymentPage.errorText.getText().contains("Geçersiz kredi kartı numarası"));
        Thread.sleep(3000);
    }
}
