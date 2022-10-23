package core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static SelenideElement logo = $(".mh__sr .v-logo");
    public static SelenideElement uaLanguage = $(".mh-lang :nth-child(2)");

    public static void selectUALanguage() {
        if (uaLanguage.is(Condition.visible)) {
            uaLanguage.click();
            logo.shouldHave(Condition.visible);
        }
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

        public userProfile logout() {
            $(logoutButton).click();
            return this;
        }

        public userProfile openInfoMenu() {
            $(infoButton).click();
            return this;
        }

    }
}