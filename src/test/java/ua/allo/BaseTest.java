package ua.allo;

import com.codeborne.selenide.Condition;
import core.ChromeDriverWeb;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static core.BasePage.logo;
import static org.hamcrest.MatcherAssert.assertThat;


public class BaseTest extends ChromeDriverWeb {

    @Test
    public void baseTest() throws InterruptedException {
        //Wait until main page visible
        logo.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}