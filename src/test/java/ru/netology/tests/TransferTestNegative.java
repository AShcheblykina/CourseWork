package ru.netology.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.netology.page.VerificationPage;

import java.time.Duration;

public class TransferTestNegative {
    @Test
    void testInvalidCard() {
        Selenide.open("http://localhost:8080");
        var verificationPage = new VerificationPage();
        verificationPage.initialize();
        verificationPage.infoCardPositive();




        verificationPage.infoCardNegativeString();


//        Selenide.$(Selectors.byText("Купить в кредит")).click();
//        Selenide.$("[placeholder='0000 0000 0000 0000']").setValue("kkkk kkkk kkkk kkkk");
//        Selenide.$("[placeholder='08']").setValue("12");
//        Selenide.$("[placeholder='22']").setValue("23");
//        Selenide.$$(By.className("input__control")).get(3).setValue("Микки Маус");
//        Selenide.$$(By.className("input__control")).get(4).setValue("111");
//        Selenide.$(Selectors.byText("Продолжить")).click();
//        Selenide.$(Selectors.byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    void testInvalidCardNumber() {
        Selenide.open("http://localhost:8080");
        Selenide.$(Selectors.byText("Купить в кредит")).click();
        Selenide.$("[placeholder='0000 0000 0000 0000']").setValue("0000 0000 0000 0000");
        Selenide.$("[placeholder='08']").setValue("12");
        Selenide.$("[placeholder='22']").setValue("23");
        Selenide.$$(By.className("input__control")).get(3).setValue("Минни Маус");
        Selenide.$$(By.className("input__control")).get(4).setValue("100");
        Selenide.$(Selectors.byText("Продолжить")).click();
        Selenide.$x("(//*[@class='notification__icon'])[1]").shouldBe(Condition.visible, Duration.ofSeconds(17));

    }

    @Test
    void testInvalidMouth() {
        Selenide.open("http://localhost:8080");
        Selenide.$(Selectors.byText("Купить в кредит")).click();
        Selenide.$("[placeholder='0000 0000 0000 0000']").setValue("5555 6666 7777 8888");
        Selenide.$("[placeholder='08']").setValue("04");
        Selenide.$("[placeholder='22']").setValue("23");
        Selenide.$$(By.className("input__control")).get(3).setValue("Дэйл");
        Selenide.$$(By.className("input__control")).get(4).setValue("123");
        Selenide.$(Selectors.byText("Продолжить")).click();
        Selenide.$(Selectors.byText("Неверно указан срок действия карты")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    void testInvalidYear() {
        Selenide.open("http://localhost:8080");
        Selenide.$(Selectors.byText("Купить в кредит")).click();
        Selenide.$("[placeholder='0000 0000 0000 0000']").setValue("5555 6666 7777 8888");
        Selenide.$("[placeholder='08']").setValue("12");
        Selenide.$("[placeholder='22']").setValue("19");
        Selenide.$$(By.className("input__control")).get(3).setValue("Чип");
        Selenide.$$(By.className("input__control")).get(4).setValue("123");
        Selenide.$(Selectors.byText("Продолжить")).click();
        Selenide.$(Selectors.byText("Истёк срок действия карты")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    void testInvalidName() {
        Selenide.open("http://localhost:8080");
        Selenide.$(Selectors.byText("Купить в кредит")).click();
        Selenide.$("[placeholder='0000 0000 0000 0000']").setValue("5555 6666 7777 8888");
        Selenide.$("[placeholder='08']").setValue("12");
        Selenide.$("[placeholder='22']").setValue("23");
        Selenide.$$(By.className("input__control")).get(3).setValue("sdfrgjkkfdjgh");
        Selenide.$$(By.className("input__control")).get(4).setValue("123");
        Selenide.$(Selectors.byText("Продолжить")).click();
        Selenide.$(Selectors.byText("Укажите корректные данные владельца карты")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    void testInvalidCVC() {
        Selenide.open("http://localhost:8080");
        Selenide.$(Selectors.byText("Купить в кредит")).click();
        Selenide.$("[placeholder='0000 0000 0000 0000']").setValue("5555 6666 7777 8888");
        Selenide.$("[placeholder='08']").setValue("12");
        Selenide.$("[placeholder='22']").setValue("23");
        Selenide.$$(By.className("input__control")).get(3).setValue("Эрих Мария Ремарк");
        Selenide.$$(By.className("input__control")).get(4).setValue("ЦУВ");
        Selenide.$(Selectors.byText("Продолжить")).click();
        Selenide.$(Selectors.byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

}