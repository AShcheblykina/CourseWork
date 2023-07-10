import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MoneyTransferTest {
    @Test
    void testPayment() {
        open("http://localhost:8080");
        $(byText("Купить")).click();
        $("[placeholder='0000 0000 0000 0000']").setValue("1111 2222 3333 4444");
        $("[placeholder='08']").setValue("10");
        $("[placeholder='22']").setValue("23");
        $("[type='text']").setValue("Иван Федорович Достоевский");
        $(byText("CVC/CVV")).setValue("999");
        $(byText("Продолжить")).click();
        $(byText("Операция одобрена Банком")).shouldBe(visible, Duration.ofMillis(5000));

    };




}
