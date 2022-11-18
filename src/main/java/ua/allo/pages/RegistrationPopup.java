package ua.allo.pages;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPopup {
    public void clickOnClose(){
        $(".v-modal__close-btn .vi.i-shared.vi__close").click();
    }

    public RegistrationPopup clickOnRegistration(){
        $("#form-validate-register .modal-submit-button").click();
        return this;
    }

    public RegistrationPopup fillName(String input){
        $("#v-register-name").val(input);
        return this;
    }

    public RegistrationPopup fillPhone(String input){
        $("#v-register_telephone_number").val(input);
        return this;
    }

    public RegistrationPopup fillPassword(String input){
        $("#vregister-password").val(input);
        return this;
    }
}
