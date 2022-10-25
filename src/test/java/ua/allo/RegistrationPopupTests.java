package ua.allo;

import com.codeborne.selenide.Condition;
import core.LoginPopup;
import core.MainPage;
import core.RegistrationPopup;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPopupTests extends BaseConfig{
    @Test
    public void RegistrationTest() {
        var EmptyFieldError = "Це поле є обов'язковим для заповнення.";

        new MainPage.userProfile()
                .openLoginPopup();
        new LoginPopup()
                .openRegistrationPopup();
        new RegistrationPopup()
                .clickOnRegistration();
        $(".validation-advice.v-validation-error div").shouldHave(Condition.text(EmptyFieldError));
        $(".validation-advice.v-validation-error div").shouldHave(Condition.text(EmptyFieldError));


    }
}
