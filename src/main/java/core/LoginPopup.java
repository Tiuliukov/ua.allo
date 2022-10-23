package core;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPopup {
    public static SelenideElement accountIcon = $(".mh__sr .v-logo");

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
}
