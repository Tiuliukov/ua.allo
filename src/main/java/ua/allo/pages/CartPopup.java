package ua.allo.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class CartPopup {
    public void clickOnClose(){
        $(".v-modal__close-btn .vi__close").click();
    }

    public void ClickOnCheckout() {
        $(".cart-popup__content .order-now").click();
    }

    private ProductComponent productComponent = new ProductComponent();

    public void removeProductFromCart (String productId){
        $("[data-product-id='7368993'] .remove").click();
    }

    public String getProductTitleById(String productId) {
        return $("[data-product-id='7368993'] .wrap").getText();
    }

    public CartPopup checkProductTitleById(String productId, String title) {
        productComponent.findProductById(productId).shouldHave(Condition.text(title));
        return this;
    }

}
