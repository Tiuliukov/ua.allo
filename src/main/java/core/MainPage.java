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
        private By userProfileIcon = By.cssSelector(".vi.i-header.vi__info");

        public void openLoginPopup() {
            $(userProfileIcon).click();
        }

        public void openRegistrationPopup() {

        }
    }
}