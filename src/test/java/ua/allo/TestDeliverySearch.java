package ua.allo;

import com.codeborne.selenide.Condition;
import core.ChromeDriverWeb;
import core.Page;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static core.Page.logo;
import static core.Page.selectRussianLanguage;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestDeliverySearch extends ChromeDriverWeb {

    @Test
    public void deliverySearchTest3() throws InterruptedException {
        //Wait until main page visible
        logo.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}