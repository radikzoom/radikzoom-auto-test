import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

    @BeforeEach
    public void setup(){
        //1. Открыть страницу https://github.com/
        open("https://github.com/");
        //2. Кликнуть на кнопку sign in
        TestPages.mainPage.mainSignInButton()
                .click();
    }

    @Test
    public void shouldAuthorizeTest() {
        //1. Заполнить инпуты логина и пароля
        TestPages.loginPage.inputLogin()
               .sendKeys("radikzoom");
        TestPages.loginPage.inputPassword()
                .sendKeys("K@zan2020");
        //2. Нажать кнопку sign in
        TestPages.loginPage.signInButton()
                .click();
        //3. Проверить авторизацию
        TestPages.profilePage.baseHeader()
                .shouldBe(visible);
        //4. Открываем dropdown меню
        TestPages.profilePage.dropDownButton()
                .click();
        TestPages.profilePage.yourProfileButton()
                .click();
        //5. Проверить открытие страницы Your profile
        TestPages.yourProfilePage.dataPjaxReplace()
                .shouldBe(visible);
    }
}
