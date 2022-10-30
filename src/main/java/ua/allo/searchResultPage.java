package ua.allo;

import static com.codeborne.selenide.Selenide.$;

public class searchResultPage {
    public String getSearchResulttiitle() {
        return $(".b-crumbs__link b").getText();
    }
}
