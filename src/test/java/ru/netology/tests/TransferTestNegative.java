package ru.netology.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import ru.netology.page.VerificationPage;

public class TransferTestNegative {
    @Test
    void testInvalidCard() {
        Selenide.open("http://localhost:8080");
        var verificationPage = new VerificationPage();
        verificationPage.initialize();
        verificationPage.infoCardNegativeString();
    }
    @Test
    void testInvalidCardNumber() {
        Selenide.open("http://localhost:8080");
        var verificationPage = new VerificationPage();
        verificationPage.initialize();
        verificationPage.infoCardNegativeNumber();
    }
    @Test
    void testInvalidOwner() {
        Selenide.open("http://localhost:8080");
        var verificationPage = new VerificationPage();
        verificationPage.initialize();
        verificationPage.invalidOwner();
    }
    @Test
    void testInvalidCvc() {
        Selenide.open("http://localhost:8080");
        var verificationPage = new VerificationPage();
        verificationPage.initialize();
        verificationPage.invalidCvc();
    }


}