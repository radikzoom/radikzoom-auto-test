import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("radikzoom")
@Feature("Авторизация")

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
    @Severity(CRITICAL)
    @Story("Логин")
    public void shouldAuthorizeTest() {
        step("Заполнить поля авторизации и нажать кнопку авторизации", () -> {
            TestPages.loginPage.inputLogin()
                    .sendKeys("radikzoom");
            TestPages.loginPage.inputPassword()
                    .sendKeys("K@zan2020");
            TestPages.loginPage.signInButton()
                    .click();
        });

        step("Проверка авторизации", () -> {
            TestPages.profilePage.baseHeader()
                    .shouldBe(visible);
        });

        step("Переход на страницу Your profile", () -> {
            TestPages.profilePage.dropDownButton()
                    .click();
            TestPages.profilePage.yourProfileButton()
                    .click();
        });

        step("Проверка открытии страницы Your profile", () -> {
            TestPages.yourProfilePage.dataPjaxReplace()
                    .shouldBe(visible);
        });
    }
}
