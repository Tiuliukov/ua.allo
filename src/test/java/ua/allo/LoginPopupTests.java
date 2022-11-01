package ua.allo;

import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static ua.allo.Header.*;


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
        var FailedLoginEmailError = "Користувач з email failedLogin.aqa@gmail.com не зареєстрований. Будь ласка, зареєструйтесь чи авторизуйтесь за допомогою номеру телефона.\n";
        var FailedLoginInvalidEmailError = "Будь ласка, вкажіть коректний email";
        var FailedLoginPhoneError = "Номер телефону +380503412340 недоступний для авторизації. Увійдіть під іншим номером або зареєструйтесь.";
        var EmptyFieldError = "Це поле є обов'язковим для заповнення.";

        new userProfile()
                .openLoginPopup();
        new LoginPopup()
                .clickOnLogin();

                                         /* Need fix selector. May be unstable */

        $("[type='login'] .validation-advice.v-validation-error").shouldHave(Condition.text(EmptyFieldError));
        $("#form-validate-login :nth-child(4)").shouldHave(Condition.text(EmptyFieldError));
        new LoginPopup()
                .clickOnClose();

        new userProfile()
                .openLoginPopup();
        new LoginPopup()
                .fillLogin("failedLogin.aqa@gmail.com")
                .fillPassword("IvCUZ4qv5")
                .clickOnLogin();
        $(".validation-advice.v-validation-error div").shouldHave(Condition.text(FailedLoginEmailError));
        new LoginPopup()
                .clickOnClose();

        new userProfile()
                .openLoginPopup();
        new LoginPopup()
                .cleanLoginField()
                .fillLogin("failedLogin")
                .fillPassword("IvCUZ4qv5")
                .clickOnLogin();
        $(".validation-advice.v-validation-error div").shouldHave(Condition.text(FailedLoginInvalidEmailError));
        new LoginPopup()
                .clickOnClose();

        new userProfile()
                .openLoginPopup();
        new LoginPopup()
                .cleanLoginField()
                .fillLogin("+380503412340")
                .fillPassword("IvCUZ4qv5")
                .clickOnLogin();
        $(".validation-advice.v-validation-error div").shouldHave(Condition.text(FailedLoginPhoneError));
    }
}
