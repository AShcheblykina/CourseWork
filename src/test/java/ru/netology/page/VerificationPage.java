package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

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
    private SelenideElement popUp =  $x("(//*[@class='notification__icon'])[1]");
    private SelenideElement invalidCardNumberString = $(Selectors.byText("Неверный формат"));
    private SelenideElement invalidCardNumber = $x("(//*[@class='notification__icon'])[1]");
    private SelenideElement invalidName = $(Selectors.byText("Укажите корректные данные владельца карты"));
    private SelenideElement invalidCvc = $(Selectors.byText("Неверный формат"));

    public void initialize() {
        creditBuy.click();
    }
    public void initializeBy() {
      creditSell.click();
    }

    public void infoCardPositive() {
        creditBuy.click();
//      creditSell.click();
        cardNumber.setValue("5555 6666 7777 8888");
        mouth.setValue("11");
        year.setValue("23");
        owner.setValue("Иван Федорович Достоевский");
        cvc.setValue("999");
        notification.click();
    }
    public void positiveNotification() {
        popUp.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void infoCardNegativeString() {
        cardNumber.setValue("kkkk kkkk kkkk kkkk");
        mouth.setValue("12");
        year.setValue("25");
        owner.setValue("Дэд Пул");
        cvc.setValue("999");
        notification.click();
        invalidCardNumberString.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    public void infoCardNegativeNumber(){
        cardNumber.setValue("0000 0000 0000 0000");
        mouth.setValue("11");
        year.setValue("23");
        owner.setValue("Микки Маус");
        cvc.setValue("999");
        notification.click();
        invalidCardNumber.shouldBe(Condition.visible, Duration.ofSeconds(17));
    }
    public void invalidOwner() {
        cardNumber.setValue("5555 6666 7777 8888");
        mouth.setValue("11");
        year.setValue("23");
        owner.setValue("sdfrgjkkfdjgh");
        cvc.setValue("999");
        notification.click();


    }
    public void invalidCvc () {
        creditBuy.click();
        cardNumber.setValue("5555 6666 7777 8888");
        mouth.setValue("11");
        year.setValue("23");
        owner.setValue("Иван Федорович Достоевский");
        cvc.setValue("GFF");
        notification.click();
        invalidCvc.shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

}
