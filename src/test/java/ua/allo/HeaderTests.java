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

    @Test
    public void checkContactsTests() {
        var phone_1 = "0 800 300 100";
        var phone_2 = "(056) 790-12-34";
        new MainPage()
                .openContactsPopup();
        $(".phone-block:nth-child(1) .phone-block__number:nth-child(2)").shouldHave(Condition.text(phone_1));
        $(".phone-block:nth-child(2) .phone-block__number:nth-child(2)").shouldHave(Condition.text(phone_2));
    }
    @Test
    public void changeLanguageTests() {
        var ruText = "Магазины";
        var uaText = "Магазини";
        new MainPage()
                .chooseRULanguage();
        $(".mh-links a[href='https://allo.ua/ru/offline_stores/']").shouldHave(Condition.text(ruText));
        new MainPage()
                .chooseUALanguage();
        $(".mh-links a[href='https://allo.ua/ua/offline_stores/']").shouldHave(Condition.text(uaText));
    }
}
