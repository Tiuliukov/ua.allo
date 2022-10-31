package ua.allo;

import com.codeborne.selenide.Condition;
import core.LoginPopup;
import core.Header;
import core.RegistrationPopup;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPopupTests extends BaseConfig{
    @Test
    public void RequiredFieldsTest() {
        var EmptyFieldError = "Це поле є обов'язковим для заповнення.";

        new Header.userProfile()
                .openLoginPopup();
        new LoginPopup()
                .openRegistrationPopup();
        new RegistrationPopup()
                .clickOnRegistration();
        $(".validation-list .validation-text").shouldHave(Condition.text(EmptyFieldError));
        $(".modal-input:nth-child(2) .validation-advice").shouldHave(Condition.text(EmptyFieldError));
        $(".modal-input:nth-child(4) .validation-advice").shouldHave(Condition.text(EmptyFieldError));
    }

    @Test
    public void SendRegistrationRequestTest() {
        var description = "Введіть код підтвердження з sms / viber, відправлений на номер";
        var testPhone = "0511112233";
        var testName = "Test";
        var testPass = "Qwerty";
        new Header.userProfile()
                .openLoginPopup();
        new LoginPopup()
                .openRegistrationPopup();
        new RegistrationPopup()
                .fillName(testName)
                .fillPhone(testPhone)
                .fillPassword(testPass)
                .clickOnRegistration();
        $("#login-form .code-verification-text.verification-text-last").shouldHave(Condition.text(description));
    }

    @Test
    public void AlreadyRegisterTest() {
        var description = "Користувач з номером +380985019780 вже зареєстрований. Будь ласка авторизуйтесь.";
        var testPhone = "0985019780";
        var testName = "Test";
        var testPass = "Qwerty";
        new Header.userProfile()
                .openLoginPopup();
        new LoginPopup()
                .openRegistrationPopup();
        new RegistrationPopup()
                .fillName(testName)
                .fillPhone(testPhone)
                .fillPassword(testPass)
                .clickOnRegistration();
        $(".modal-input.validation-error .validation-advice.v-validation-error").shouldHave(Condition.text(description));
    }
}
