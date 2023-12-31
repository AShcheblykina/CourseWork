package ru.netology.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import ru.netology.page.VerificationPage;

public class TransferTestPositive {
    @Test
    void testPaymentCredit() {
        Selenide.open("http://localhost:8080");
        var verificationPage = new VerificationPage();
        verificationPage.initialize();
        verificationPage.infoCardPositive();
        verificationPage.positiveNotification();
    }

}
