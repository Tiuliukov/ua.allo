package ua.allo;

import core.ChromeDriverWeb;
import core.LoginPopup;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static core.MainPage.*;


public class LoginPopupTests extends ChromeDriverWeb {

    @Test
    public void successLoginTest() {
        new userProfile()
                .openLoginPopup();
        new LoginPopup()
                .fillLogin("tmp.test.user.aqa@gmail.com")
                .fillPassword("IvCUZ4qv5")
                .clickOnLogin();
    }
}
