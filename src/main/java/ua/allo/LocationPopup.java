package ua.allo;

import static com.codeborne.selenide.Selenide.$;

public class LocationPopup {
    public void fillSearch(String input){
        $("#city").val(input);
    }

    public LocationPopup partialFillSearch(String input){
        $("#city").val(input);
        return this;
    }

    public void chooseLastCity() {
        $(".geo .geo__cities :last-child").click();
    }
}
