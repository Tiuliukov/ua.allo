package ua.allo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

public class Header {
    public static SelenideElement logo = $(".mh__sr .v-logo");

    public void openLocationPopup() {
        $(".mh .mh-loc").click();
    }

    public String getCurrentLocation() {
        return $(".mh-loc .mh-loc__label").getText();
    }

    public void openStoresPage() {
        $(".mh-links a[href$='/offline_stores/']").click();
    }

    public void openDiscountsPage() {
        $(".mh-links a[href$='/events-and-discounts/']").click();
    }

    public void openLoyalityProgramPage() {
        $(".mh-links a[href$='/loyalty-program/']").click();
    }

    public void openTradeinPage() {
        $(".mh-links a[href$='/tradein/']").click();
    }



    public static class forBuyers {
        private final By forBuyersButton = cssSelector(".vi.i-header.vi__info"),
                        shipmentPaymentButton = cssSelector(".mh-button__wrap a[href$='/shipment_payment/']"),
                        oplataChastamiButton = cssSelector(".mh-button__wrap a[href$='/oplata-chastami/']"),
                        warrantyAndServiceButton = cssSelector(".mh-button__wrap a[href$='/warranty_and_service']"),
                        golovnaButton = cssSelector(".mh-button__wrap a[href$='/golovna/']");

        public forBuyers openForBuyersPopup() {
            $(forBuyersButton).click();
            return this;
        }
    }

    public void openContactsPopup() {
        $(".mh .mh__fr .mh-phone .mh-button").click();
    }

    public void searchFor(String searchQuery) {
        $("#search-form__input").val(searchQuery).pressEnter();
    }



    public static class userProfile {
        private final By userProfileIcon = cssSelector(".vi.i-header.vi__info"),
                        bonusesButton = cssSelector(".mh-profile .mh-button.bonuses"),
                        ordersButton = cssSelector(".mh-button.orders"),
                        viewedButton = cssSelector(".mh-button.viewed"),
                        commentsButton = cssSelector(".mh-button.comments"),
                        infoButton = cssSelector(".mh-button.info"),
                        newsletterButton = cssSelector(".mh-button.newsletter"),
                        servicesButton = cssSelector(".mh-button.services"),
                        logoutButton = cssSelector(".mh-button.logout");


        public void openLoginPopup() {
            if ($(userProfileIcon).is(Condition.visible)) {
                $(userProfileIcon).click();
            }
        }

        public userProfile openUserProfileMenu() {
            if ($(userProfileIcon).is(Condition.visible)) {
                $(userProfileIcon).click();
            }
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



    public static class Language {
        private final By uaLanguage = cssSelector(".mh-lang :nth-child(2)"),
                        ruLanguage = cssSelector(".mh-lang :nth-child(1)");

        public void chooseUALanguage() {
            if ($(uaLanguage).is(Condition.visible)) {
                $(uaLanguage).click();
            }
        }

        public void chooseRULanguage() {
            if ($(ruLanguage).is(Condition.visible)) {
                $(ruLanguage).click();
            }
        }
    }
}