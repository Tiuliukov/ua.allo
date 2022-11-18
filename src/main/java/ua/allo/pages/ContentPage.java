package ua.allo.pages;

import static com.codeborne.selenide.Selectors.by;

public class ContentPage {

    private ProductComponent productComponent = new ProductComponent();

    public void addProductToCart (String productId){
        productComponent.findProductById(productId).$(".h-pc .v-btn--cart").click();
    }

    public static class banner {

    }

    public static class sliderMenu {

    }
}
