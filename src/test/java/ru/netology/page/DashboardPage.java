package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DashboardPage {

    private ElementsCollection cards = $$x("//li[@class='list__item']/div");
    private ElementsCollection actionButtons = $$x("//button[@data-test-id='action-deposit']");

    private SelenideElement reloadButton = $x("//button[@data-test-id='action-reload']");
    private SelenideElement errorNotification = $x("//div[@data-test-id='error-notification']");

    public TransferPage transferClick(int indexCardTo){
        actionButtons.get(indexCardTo).click();
        return new TransferPage();
    }

    public int getBalance(int index){
        reloadButton.click();
        String[] card = cards.get(index).toString().split(" ");
        return Integer.parseInt(card[6]);
    }

    public void assertBalance(int index, int expectedBalance){
        int actualBalance = getBalance(index);
        assertEquals(expectedBalance, actualBalance);
    }
}
