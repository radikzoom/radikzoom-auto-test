package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    public SelenideElement baseHeader() {return $(".Header").as("шапка профиля");}

    public SelenideElement dropDownButton() {return $(".details-overlay.details-reset.js-feature-preview-indicator-container")
            .as("кнопка раскрытия меню");}

    public SelenideElement yourProfileButton() {return $(byText("Your profile")).as("кнопка профиля");}
}
