package core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static SelenideElement logo = $(".mh__sr .v-logo");
    public static SelenideElement uaLanguage = $(".mh-lang :nth-child(2)");
    public static SelenideElement ruLanguage = $(".mh-lang :nth-child(1)");

    public static void selectUALanguage() {
        if (uaLanguage.is(Condition.visible)) {
            uaLanguage.click();
        }
    }

    public void searchFor(String searchQuery) {
        $("#search-form__input").val(searchQuery).pressEnter();
    }

    public static class userProfile {
        private final By userProfileIcon = By.cssSelector(".vi.i-header.vi__info"),
                        bonusesButton = By.cssSelector(".mh-profile .mh-button.bonuses"),
                        ordersButton = By.cssSelector(".mh-button.orders"),
                        viewedButton = By.cssSelector(".mh-button.viewed"),
                        commentsButton = By.cssSelector(".mh-button.comments"),
                        infoButton = By.cssSelector(".mh-button.info"),
                        newsletterButton = By.cssSelector(".mh-button.newsletter"),
                        servicesButton = By.cssSelector(".mh-button.services"),
                        logoutButton = By.cssSelector(".mh-button.logout");


        public void openLoginPopup() {
            $(userProfileIcon).click();
        }

        public userProfile openUserProfileMenu() {
            $(userProfileIcon).click();
            return this;
        }

        public void logout() {
            $(logoutButton).click();
        }

        public userProfile openInfoMenu() {
            $(infoButton).click();
            return this;
        }

    }

    public void openLocation() {
        $(".mh .mh-loc").click();
    }

    public String getLocation() {
        return $(".mh-loc .mh-loc__label").getText();
    }

    public void openStoresPage() {
        $(".mh-links a[href='https://allo.ua/ua/offline_stores/']").click();
    }

    public void openContactsPopup() {
        $(".mh .mh__fr .mh-phone .mh-button").click();
    }
    public void chooseUALanguage() {
        $(uaLanguage).click();
    }
    public void chooseRULanguage() {
        $(ruLanguage).click();
    }
}