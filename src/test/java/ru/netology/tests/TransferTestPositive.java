package ru.netology.tests;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TransferTestPositive {
    @Test
    void testPaymentCredit() {
        open("http://localhost:8080");
        $(byText("Купить в кредит")).click();
        $("[placeholder='0000 0000 0000 0000']").setValue("5555 6666 7777 8888");
        $("[placeholder='08']").setValue("11");
        $("[placeholder='22']").setValue("23");
        $$(By.className("input__control")).get(3).setValue("Иван Федорович Достоевский");
        $$(By.className("input__control")).get(4).setValue("999");
        $(byText("Продолжить")).click();
        $x("(//*[@class='notification__icon'])[1]").shouldBe(Condition.visible, Duration.ofSeconds(15));


    }

}
