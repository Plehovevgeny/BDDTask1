package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.helper.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {

    private SelenideElement codeInput = $x("//span[@data-test-id='code']//input");
    private SelenideElement verifyButton = $x("//button[@data-test-id='action-verify']");

    public VerificationPage(){
        codeInput.should(visible);
    }

    public DashboardPage verify(DataHelper.VerificationCode verificationCode){
        codeInput.val(verificationCode.getCode());
        verifyButton.click();
        return new DashboardPage();
    }
}
