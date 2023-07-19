package ru.netology.page;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NotificationPage {
    private SelenideElement popUp =  $x("(//*[@class='notification__icon'])[1]");
    private SelenideElement invalidCardNumberString = $(Selectors.byText("Неверный формат"));
    private SelenideElement invalidCardNumber = $x("(//*[@class='notification__icon'])[1]");
    private SelenideElement cardExpired = $(Selectors.byText("Истёк срок действия карты"));
    private SelenideElement invalidName = $(Selectors.byText("Укажите корректные данные владельца карты"));
    private SelenideElement invalidCvc = $(Selectors.byText("Неверный формат"));

}
