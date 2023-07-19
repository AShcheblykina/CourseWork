package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormData {
    private FormData(String cardNumber, String month, String year, String name, String cvc) {

    }

    @Value
    public static class Info {
        private String name;
        private String cardNumber;
        private String month;
        private String year;
        private String cvc;
    }

    public static Info getCreditInfo() {
        return new Info("5555 6666 7777 8888", "12", "23", "Иван Федоровчи Достоевский", "666");
    }

    public static Info getByuInfo() {
        return new Info("1111 2222 3333 4444", "11", "24", "Дэдпул", "333");
    }

    public static Info getRandomInfo() {
        return new Info(generatecardNumber(), generatemonth(4), generateyear(3), generatename("en"), generateCvc());
    }

    private static Faker faker;

    public static String generatecardNumber() {
        faker = new Faker();
        String randomCardNumber = faker.business().creditCardNumber();
        return randomCardNumber;
    }

    public static String generatemonth(int shift) {
        return LocalDate.now().plusMonths(shift).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateyear(int shift) {
        return LocalDate.now().plusYears(shift).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generatename(String locale) {
        faker = new Faker();
        String randomName = faker.name().fullName();
        return randomName;
    }

    public static String generateCvc() {
        String randomCvc = faker.numerify("###");
        return randomCvc;
    }
}