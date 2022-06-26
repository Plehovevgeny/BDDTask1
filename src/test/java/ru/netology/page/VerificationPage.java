package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.UserData;

import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {

    private SelenideElement codeInput = $x("//span[@data-test-id='code']//input");
    private SelenideElement verifyButton = $x("//button[@data-test-id='action-verify']");

    public DashboardPage verify(UserData user){
        codeInput.val(user.getVerifyCode());
        verifyButton.click();
        return new DashboardPage();
    }
}
