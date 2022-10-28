package ua.allo;

import com.codeborne.selenide.Condition;
import core.LocationPopup;
import core.MainPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;

public class HeaderTests extends BaseConfig {

    @Test
    public void changeLocationTests() {
        var lastCityName = "Ужгород";
        new MainPage()
                .openLocation();
        new LocationPopup()
                .chooseLastCity();
        $(".mh-loc .mh-loc__label").shouldHave(Condition.text(lastCityName));
    }

    @Test
    public void StoresTests() {
        var defaultTitle = "Адреса магазинів АЛЛО";
        var lastCityTitle = "Адреса магазинів АЛЛО у Ужгороді";

        new MainPage()
                .openStoresPage();
        $(".offline-stores-content .content__title").shouldHave(Condition.text(defaultTitle));
        new MainPage()
                .openLocation();
        new LocationPopup()
                .chooseLastCity();
        $(".offline-stores-content .content__title").shouldHave(Condition.text(lastCityTitle));

    }
}
