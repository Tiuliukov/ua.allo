package ua.allo;

import com.codeborne.selenide.Condition;
import core.ChromeDriverWeb;
import core.LoginPopup;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static core.MainPage.*;


public class LoginPopupTests extends ChromeDriverWeb {


    @Test
    public void successLoginTest() {
        var welcomeText = "Вітаємо, Test";

        new userProfile()
                .openLoginPopup();
        new LoginPopup()
                .fillLogin("tmp.test.user.aqa@gmail.com")
                .fillPassword("IvCUZ4qv5")
                .clickOnLogin();
        new userProfile()
                .openUserProfileMenu()
                .openInfoMenu();
        $(".customer-account .customer-account__title").shouldHave(Condition.text(welcomeText));
    }

    @Test
    public void LoginLogoutTest() {
        var logoutText = "Ви вийшли зі свого аккаунта";
        new userProfile()
                .openLoginPopup();
        new LoginPopup()
                .fillLogin("tmp.test.user.aqa@gmail.com")
                .fillPassword("IvCUZ4qv5")
                .clickOnLogin();
        new userProfile()
                .openUserProfileMenu()
                .logout();
        $(".customer-logout .customer-logout__title").shouldHave(Condition.text(logoutText));
    }
}
