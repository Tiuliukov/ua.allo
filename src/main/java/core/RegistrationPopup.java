package core;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPopup {
    public void clickOnClose(){
        $(".v-modal__close-btn .vi.i-shared.vi__close").click();
    }

    public RegistrationPopup clickOnRegistration(){
        $(".account-login .modal-submit-button").click();
        return this;
    }
}
