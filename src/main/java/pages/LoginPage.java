package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public SelenideElement inputLogin() {return $("[id='login_field']").as("инпут логин");}

    public SelenideElement inputPassword() {return $("[id='password']").as("инпут пароля");}

    public SelenideElement signInButton() {return $(".js-sign-in-button").as("кнопка Войти");}

}
