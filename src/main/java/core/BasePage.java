package core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public static SelenideElement logo = $(".mh__sr .v-logo");
    public static SelenideElement uaLanguage = $(".mh-lang :nth-child(2)");

    public static void selectRussianLanguage() {
        if (uaLanguage.is(Condition.visible)) {
            uaLanguage.click();
            logo.shouldHave(Condition.visible);
        }
    }
}