package ua.allo.pages;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    private ProductComponent productComponent = new ProductComponent();

    public String getSearchResultPageTiitle() {
        return $ (".b-crumbs__link b").getText();
    }

    public String getFirstProductInfoTiitle() {
        return $ (".products-layout__container .product-card__title").getText();
    }

    public void openProductPage (String productId) {
        productComponent.findProductById(productId).$(".product-card__title").click();
    }


}
