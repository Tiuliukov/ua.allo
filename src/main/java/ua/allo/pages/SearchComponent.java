package ua.allo.pages;

import static com.codeborne.selenide.Selenide.$;

public class SearchComponent {
    public void searchFor(String searchQuery) {
        $("#search-form__input").val(searchQuery).pressEnter();
    }

    public SearchComponent fillSearchQuery(String searchQuery){
        $("#search-form__input").val(searchQuery);
        return this;
    }

    public SearchComponent clickOnSearch(){
         $(".search-form__form .search-form__submit-button").click();
         return this;
    }
}
