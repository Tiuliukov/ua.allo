package ua.allo;

import com.codeborne.selenide.Condition;
import core.LoginPopup;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static core.MainPage.*;


public class LoginPopupTests extends BaseConfig {


    @Test
    public void successLoginEmailTest() {
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
    public void successLoginPhoneTest() {
        var welcomeText = "Вітаємо, Test";
        new userProfile()
                .openLoginPopup();
        new LoginPopup()
                .fillLogin("+380985019780")
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

    @Test
    public void FailedLoginTest() {
        var FailedLoginEmailText = "Користувач з email failedLogin.aqa@gmail.com не зареєстрований. Будь ласка, зареєструйтесь чи авторизуйтесь за допомогою номеру телефона.\n";
        var FailedLoginInvalidEmailText = "Будь ласка, вкажіть коректний email";
        var FailedLoginPhoneText = "Номер телефону +380503412340 недоступний для авторизації. Увійдіть під іншим номером або зареєструйтесь.";
        new userProfile()
                .openLoginPopup();
        new LoginPopup()
                .fillLogin("failedLogin.aqa@gmail.com")
                .fillPassword("IvCUZ4qv5")
                .clickOnLogin();
        $(".validation-advice.v-validation-error div").shouldHave(Condition.text(FailedLoginEmailText));
        new LoginPopup()
                .clickOnClose();
        new userProfile()
                .openLoginPopup();
        new LoginPopup()
                .cleanLoginField()
                .fillLogin("failedLogin")
                .fillPassword("IvCUZ4qv5")
                .clickOnLogin();
        $(".validation-advice.v-validation-error div").shouldHave(Condition.text(FailedLoginInvalidEmailText));
        new LoginPopup()
                .clickOnClose();
        new userProfile()
                .openLoginPopup();
        new LoginPopup()
                .cleanLoginField()
                .fillLogin("+380503412340")
                .fillPassword("IvCUZ4qv5")
                .clickOnLogin();
        $(".validation-advice.v-validation-error div").shouldHave(Condition.text(FailedLoginPhoneText));
    }
}
