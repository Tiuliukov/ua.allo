package ua.allo;

import static com.codeborne.selenide.Selenide.$;

public class LoginPopup {

    public LoginPopup fillLogin(String input){
        $("#auth").val(input);
        return this;
    }

    public LoginPopup fillPassword(String input){
        $("#v-login-password").val(input);
        return this;
    }

    public LoginPopup clickOnLogin(){
        $(".account-login .modal-submit-button").click();
        return this;
    }

    public void clickOnClose(){
        $(".v-modal__close-btn .vi.i-shared.vi__close").click();
    }

    public void openRegistrationPopup(){
        $(".customer-tabs :nth-child(2)").click();
    }

    public LoginPopup cleanLoginField(){
        $("#auth").clear();
        return this;
    }
}
