package core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Page {
    public static SelenideElement logo = $(".header__logo");
    public static SelenideElement ruLanguage = $(byXpath("//a[contains(text(), 'RU')]"));

    public static void selectRussianLanguage() {
        if (ruLanguage.is(Condition.visible)) {
            ruLanguage.click();
            logo.shouldHave(Condition.visible);
        }
    }
}