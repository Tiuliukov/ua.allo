package ua.allo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.by;


public class ProductComponent {
    public SelenideElement findProductById(String productId){
        return $(by("data-product-id", productId));
    }

}
