package ua.allo;

import com.codeborne.selenide.Condition;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static ua.allo.Header.logo;

public class HeaderTests extends BaseConfig {

    @Test
    public void baseTest() {
        //Wait until main page visible
        logo.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    @Test
    public void changeLocationTest() {
        var lastCityName = "Ужгород";
        new Header()
                .openLocationPopup();
        new LocationPopup()
                .chooseLastCity();
        $(".mh-loc .mh-loc__label").shouldHave(Condition.text(lastCityName));
    }

    @Test
    public void StoresTest() {
        var defaultTitle = "Адреса магазинів АЛЛО";
        var lastCityTitle = "Адреса магазинів АЛЛО у Ужгороді";

        new Header()
                .openStoresPage();
        $(".offline-stores-content .content__title").shouldHave(Condition.text(defaultTitle));
        new Header()
                .openLocationPopup();
        new LocationPopup()
                .chooseLastCity();
        $(".offline-stores-content .content__title").shouldHave(Condition.text(lastCityTitle));

    }

    @Test
    public void checkContactsTests() {
        var phone_1 = "0 800 300 100";
        var phone_2 = "(056) 790-12-34";
        new Header()
                .openContactsPopup();
        $(".phone-block:nth-child(1) .phone-block__number:nth-child(2)").shouldHave(Condition.text(phone_1));
        $(".phone-block:nth-child(2) .phone-block__number:nth-child(2)").shouldHave(Condition.text(phone_2));
    }
    @Test
    public void changeLanguageTests() {
        var ruText = "Магазины";
        var uaText = "Магазини";
        new Header.Language()
                .chooseRULanguage();
        $(".mh-links a[href='https://allo.ua/ru/offline_stores/']").shouldHave(Condition.text(ruText));
        new Header.Language()
                .chooseUALanguage();
        $(".mh-links a[href='https://allo.ua/ua/offline_stores/']").shouldHave(Condition.text(uaText));
    }
}
