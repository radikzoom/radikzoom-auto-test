package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ReleasesPage {

    public SelenideElement inputSearch() {return $("[type=\"search\"]").as("инпут ввода поиска");}

    public SelenideElement releaseCard() {return $(".d-inline.mr-3").as("имя карточки релиза");}
}
