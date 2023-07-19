package ru.netology.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import ru.netology.page.VerificationPage;

public class TransferTestPositive {
    @Test
    void testPaymentCredit() {
        Selenide.open("http://localhost:8080");
        var verificationPage = new VerificationPage();






//        $(byText("Купить в кредит")).click();
//        $("[placeholder='0000 0000 0000 0000']").setValue("5555 6666 7777 8888");
//        $("[placeholder='08']").setValue("11");
//        $("[placeholder='22']").setValue("23");
//        $$(By.className("input__control")).get(3).setValue("Иван Федорович Достоевский");
//        $$(By.className("input__control")).get(4).setValue("999");
//        $(byText("Продолжить")).click();
//        $x("(//*[@class='notification__icon'])[1]").shouldBe(Condition.visible, Duration.ofSeconds(15));


    }


}
