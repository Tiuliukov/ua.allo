package ua.allo;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ua.allo.pages.CartPopup;
import ua.allo.pages.ContentPage;
import ua.allo.pages.Header;
import ua.allo.pages.SearchResultPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;


public class ContentPageTests extends BaseConfig{

    @Test
    public void addRecentlyOpenedToCartTest() {
        var productName = "Xiaomi Redmi Note";
        var productId = "7368993";
        new Header().searchComponent
                .searchFor(productName);
        new SearchResultPage()
                .openProductPage(productId);
        $(".v-logo").click();
        $(".v-footer .v-footer__social").scrollIntoView(true);
        $(by("data-id", productId)).$(".v-btn--cart").click();
        //var actualProductTitle = new CartPopup().getProductTitleById("7368993");
        //Assertions.assertEquals(productName,actualProductTitle);
        $("[data-product-id=\"7368993\"] .wrap").shouldHave(text(productName));

    }
}
