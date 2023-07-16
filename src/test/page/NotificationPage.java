package ru.netology.page
import static com.codeborne.selenide.Selenide.$;

public class NotificationPage {
    Selenide Element notification =  $(byText("Продолжить"));
    Selenide Element popUp =  $x("(//*[@class='notification__icon'])[1]");
}
