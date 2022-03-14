package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    public SelenideElement baseHeader() {return $(".Header").as("шапка профиля");}

    public SelenideElement dropDownButton() {return $(".details-overlay.details-reset.js-feature-preview-indicator-container")
            .as("кнопка раскрытия меню");}

    public SelenideElement yourProfileButton() {return $(byText("Your profile")).as("кнопка профиля");}

    public SelenideElement switchBranchesButton() {return $(".btn.css-truncate").as("кнопка переключения веток");}

    public SelenideElement fixturesBranchesButton() {return $("[href=\"https://github.com/junit-team/junit4/tree/fixtures\"]")
            .as("кнопка выбора ветки Fixtures");}

    public SelenideElement nameBranches() {return $("[id=branch-select-menu]").as("текст назавнаие ветки");}

    public SelenideElement releasesButton() {return $("[href=\"/junit-team/junit4/releases\"]").as("кнопка Releases");}
}
