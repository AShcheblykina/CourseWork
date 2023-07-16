package ru.netology.data;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement cardNumber =  $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement mouth =  $("[placeholder='08']");
    private SelenideElement year =  $("[placeholder='22']");
    private SelenideElement owner =  $$(By.className("input__control")).get(3);
    private SelenideElement cvc = $$(By.className("input__control")).get(4);

}