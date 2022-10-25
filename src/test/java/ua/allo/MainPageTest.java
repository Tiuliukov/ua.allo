package ua.allo;

import com.codeborne.selenide.Condition;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static core.MainPage.logo;
import static org.hamcrest.MatcherAssert.assertThat;


public class MainPageTest extends BaseConfig {

    @Test
    public void baseTest() {
        //Wait until main page visible
        logo.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}