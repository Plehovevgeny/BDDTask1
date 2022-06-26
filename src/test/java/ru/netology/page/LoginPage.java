package ru.netology.page;


import com.codeborne.selenide.SelenideElement;
import ru.netology.data.UserData;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement loginInput = $x("//span[@data-test-id='login']//input");
    private SelenideElement passwordInput = $x("//span[@data-test-id='password']//input");
    private SelenideElement loginButton = $x("//button[@data-test-id='action-login']//span[@class='button__text']");

    public VerificationPage login(UserData user) {
        loginInput.val(user.getLogin());
        passwordInput.val(user.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
