package ua.allo;

import static com.codeborne.selenide.Selenide.$;

public class CartPopup {
    public void clickOnClose(){
        $(".v-modal__close-btn .vi__close").click();
    }

    public void ClickOnCheckout() {
        $(".cart-popup__content .order-now").click();
    }
}
