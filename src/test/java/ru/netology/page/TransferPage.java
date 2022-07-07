package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.helper.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.valueOf;

public class TransferPage {

    private static SelenideElement amountInput = $x("//span[@data-test-id='amount']//input");
    private static SelenideElement formInput = $x("//span[@data-test-id='from']//input");
    private static SelenideElement transferButton = $x("//button[@data-test-id='action-transfer']");
    private SelenideElement cancelButton = $x("//button[@data-test-id='action-cancel']");
    private SelenideElement errorNotification = $x("//div[@data-test-id='error-notification']");
    private SelenideElement errorButton = $x("//div[@data-test-id='error-notification']/button");

    public static void transferMoney(int amount, DataHelper.CardInfo from) {
        amountInput.val(valueOf(amount));
        formInput.setValue(valueOf(from));
        transferButton.click();
        new DashboardPage();
    }

    public static void errorLimit() {
        $(".notification__content").should(Condition.exactText("Ошибка"));
    }

    public static void invalidCard() {
        $(".notification__content").should(Condition.text("Ошибка! Произошла ошибка"));
    }
}
