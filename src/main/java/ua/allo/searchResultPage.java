package ua.allo;

import static com.codeborne.selenide.Selenide.$;

public class searchResultPage {
    public String getSearchResultTiitle() {
        return $(".b-crumbs__link b").getText();
    }
}
