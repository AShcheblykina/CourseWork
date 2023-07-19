package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class VerificationPage {
    private SelenideElement creditBuy = $(byText("Купить в кредит"));
    private SelenideElement creditSell = $x("//span[text()='Купить']");
    private SelenideElement cardNumber = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement mouth = $("[placeholder='08']");
    private SelenideElement year = $("[placeholder='22']");
    private SelenideElement owner = $$(By.className("input__control")).get(3);
    private SelenideElement cvc = $$(By.className("input__control")).get(4);
    private SelenideElement notification =  $(byText("Продолжить"));




}