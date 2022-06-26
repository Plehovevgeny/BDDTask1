package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.UserData;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.TransferPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;

public class TransferTests {

    UserData user;
    DashboardPage dashboardPage;

    @BeforeEach
    public void auth(){
        open("http://localhost:9999/");
        LoginPage login = new LoginPage();
        user = new UserData();
        VerificationPage verificationPage = login.login(user);
        dashboardPage = verificationPage.verify(user);
    }

    @Test
    public void shouldTransferBoundaryValue1(){
        TransferPage transferPage = dashboardPage.transferClick(0);
        transferPage.transfer(user, 5_000, 1);
        dashboardPage.assertBalance(0, 15_000);
        dashboardPage.assertBalance(1, 5_000);
        dashboardPage.transferClick(1);
        transferPage.transfer(user, 5_000, 0);
        dashboardPage.assertBalance(0, 10_000);
        dashboardPage.assertBalance(1, 10_000);
    }
}
