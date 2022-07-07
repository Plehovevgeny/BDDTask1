package ru.netology.page;


import com.codeborne.selenide.SelenideElement;
import ru.netology.helper.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement loginInput = $x("//span[@data-test-id='login']//input");
    private SelenideElement passwordInput = $x("//span[@data-test-id='password']//input");
    private SelenideElement loginButton = $x("//button[@data-test-id='action-login']//span[@class='button__text']");

    public LoginPage() {
        loginInput.should(visible);
        passwordInput.should(visible);
        loginButton.should(visible);
    }

    public VerificationPage login(DataHelper.UserInfo info) {
        loginInput.val(info.getLogin());
        passwordInput.val(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
