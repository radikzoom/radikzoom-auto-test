import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class JunitPageTest {

    @BeforeEach
    public void setup(){
        open("https://github.com/junit-team/junit4");
    }

    @Test
    @DisplayName("Переключение на ветку fixtures")
    public void switchToBranch(){
        TestPages.profilePage.switchBranchesButton()
                .click();
        TestPages.profilePage.fixturesBranchesButton()
                .click();
        TestPages.profilePage.nameBranches()
                .shouldHave(text("fixtures"));
    }

    @MethodSource("correctSearchData")
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Позитивные проверки поиска по релизам")
    public void searchBranchReleases(String releases) {
        TestPages.profilePage.releasesButton()
                .click();
        TestPages.releasesPage.inputSearch()
                .sendKeys(releases);
        TestPages.releasesPage.inputSearch()
                .pressEnter();
        TestPages.releasesPage.releaseCard()
                .shouldHave(text(releases));
    }

    static Stream<Arguments> correctSearchData() {
        return Stream.of(
                arguments(
                        "JUnit 4.12 Beta 3"
                ),
                arguments(
                        "JUnit 4.13 Beta 2"
                ),
                arguments(
                        "JUnit 4.13.1"
                ),
                arguments(
                        "JUnit 4.13 RC 1"
                )
        );
    }
}
