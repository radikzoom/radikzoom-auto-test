package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YourProfilePage {

    public SelenideElement dataPjaxReplace() {return $("[id='js-flash-container']").as("содержимое шаблона");}
}
