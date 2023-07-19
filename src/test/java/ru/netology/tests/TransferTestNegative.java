

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TransferTestNegative {
    @Test
    void testInvalidCard() {
        open("http://localhost:8080");
        $(byText("Купить в кредит")).click();
        $("[placeholder='0000 0000 0000 0000']").setValue("kkkk kkkk kkkk kkkk");
        $("[placeholder='08']").setValue("12");
        $("[placeholder='22']").setValue("23");
        $$(By.className("input__control")).get(3).setValue("Микки Маус");
        $$(By.className("input__control")).get(4).setValue("111");
        $(byText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    void testInvalidCardNumber() {
        open("http://localhost:8080");
        $(byText("Купить в кредит")).click();
        $("[placeholder='0000 0000 0000 0000']").setValue("0000 0000 0000 0000");
        $("[placeholder='08']").setValue("12");
        $("[placeholder='22']").setValue("23");
        $$(By.className("input__control")).get(3).setValue("Минни Маус");
        $$(By.className("input__control")).get(4).setValue("100");
        $(byText("Продолжить")).click();
        $x("(//*[@class='notification__icon'])[1]").shouldBe(Condition.visible, Duration.ofSeconds(17));

    }

    @Test
    void testInvalidMouth() {
        open("http://localhost:8080");
        $(byText("Купить в кредит")).click();
        $("[placeholder='0000 0000 0000 0000']").setValue("5555 6666 7777 8888");
        $("[placeholder='08']").setValue("04");
        $("[placeholder='22']").setValue("23");
        $$(By.className("input__control")).get(3).setValue("Дэйл");
        $$(By.className("input__control")).get(4).setValue("123");
        $(byText("Продолжить")).click();
        $(byText("Неверно указан срок действия карты")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    void testInvalidYear() {
        open("http://localhost:8080");
        $(byText("Купить в кредит")).click();
        $("[placeholder='0000 0000 0000 0000']").setValue("5555 6666 7777 8888");
        $("[placeholder='08']").setValue("12");
        $("[placeholder='22']").setValue("19");
        $$(By.className("input__control")).get(3).setValue("Чип");
        $$(By.className("input__control")).get(4).setValue("123");
        $(byText("Продолжить")).click();
        $(byText("Истёк срок действия карты")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    void testInvalidName() {
        open("http://localhost:8080");
        $(byText("Купить в кредит")).click();
        $("[placeholder='0000 0000 0000 0000']").setValue("5555 6666 7777 8888");
        $("[placeholder='08']").setValue("12");
        $("[placeholder='22']").setValue("23");
        $$(By.className("input__control")).get(3).setValue("sdfrgjkkfdjgh");
        $$(By.className("input__control")).get(4).setValue("123");
        $(byText("Продолжить")).click();
        $(byText("Укажите корректные данные владельца карты")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    void testInvalidCVC() {
        open("http://localhost:8080");
        $(byText("Купить в кредит")).click();
        $("[placeholder='0000 0000 0000 0000']").setValue("5555 6666 7777 8888");
        $("[placeholder='08']").setValue("12");
        $("[placeholder='22']").setValue("23");
        $$(By.className("input__control")).get(3).setValue("Эрих Мария Ремарк");
        $$(By.className("input__control")).get(4).setValue("ЦУВ");
        $(byText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

}