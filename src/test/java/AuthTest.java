import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;


public class AuthTest {

    @Test
    public void shouldAuthorizeTest() {
        //1. Открыть страницу https://github.com/
        open("https://github.com/");
        //2. Кликнуть на кнопку sign in
        $("[href='/login']").click();
        //3. Заполнить инпуты логина и пароля
        $("[id='login_field']").sendKeys("radikzoom");
        $("[id='password']").sendKeys("K@zan2020");
        //4. Нажать кнопку sign in
        $(".js-sign-in-button").click();
        //5. Проверить авторизацию
        $(".Header").shouldBe(visible);
        //6. Открываем dropdown меню
        $(".details-overlay.details-reset.js-feature-preview-indicator-container").click();
        $(byText("Your profile")).click();
        //7. Проверить открытие страницы Your profile
        $("[id='js-flash-container']").shouldBe(visible);
        //sleep(4000);
    }
}
