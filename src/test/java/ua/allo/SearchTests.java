package ua.allo;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends BaseConfig{
    @Test
    public void SearchProductByTitleAndAddToCartTest() {
        var productName = "Google Pixel 6";
        var productIdOne = "9298909";
        var productIdTwo = "1195302";
        new Header()
                .searchFor(productName);
        $(".b-crumbs__link :first-child").shouldHave(text(productName));
        findProductById(productIdOne).$(".product-card__title").shouldHave(text(productName));
        findProductById(productIdOne).$(".v-btn--cart").click();
        $(".v-modal__close-btn .vi__close").click();
        findProductById(productIdTwo).$(".v-btn--cart").click();
        $(".cart-popup .v-modal__cmp-header-title").shouldHave(text("Кошик"));
        $$(".cart-popup__content li").shouldHave(CollectionCondition.size(2));
        $(".title .wrap").shouldHave(text(productName));
    }

    @Test
    public void SearchProductByTitle() {
        var productName = "Google Pixel 6 8/256GB";

        new Header().searchFor(productName);

        var actualSearchResultPageTitle = new searchResultPage().getSearchResultPageTiitle();
        Assertions.assertEquals(productName,actualSearchResultPageTitle);
        $(".product-card__content .product-card__title").shouldHave(text(productName));
    }

    private SelenideElement findProductById(String productId) {
        return $(by("data-product-id", productId));
    }
}
