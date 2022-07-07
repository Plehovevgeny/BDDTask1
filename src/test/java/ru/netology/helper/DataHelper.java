package ru.netology.helper;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class UserInfo {
        private String login;
        private String password;
    }

    public static UserInfo getUserInfo() {
        return new UserInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(UserInfo userInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardInfo {
        private String card;
    }

    public static CardInfo getCardInfo1() {
        return new CardInfo("5559 0000 0000 0001");
    }

    public static CardInfo getCardInfo2() {
        return new CardInfo("5559 0000 0000 0002");
    }
}
