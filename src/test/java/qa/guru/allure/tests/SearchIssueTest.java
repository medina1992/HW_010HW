package qa.guru.allure.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.guru.allure.Steps.Steps;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SearchIssueTest extends TestBase {

    private static final String REPOSITORY = "allure-framework/allure2";

    @Test
    @DisplayName("Check Listener")
    public void pureSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $("[data-content=Issues]").shouldHave(text("Issues"));
    }

    @Test
    @DisplayName("Check Lambda (name, () -> {})")
    public void lambdaStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open("https://github.com");
        });

        step("Found repository " + REPOSITORY, () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });

        step("Click to link repository " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Check name  Issue in repository", () ->
                $("[data-content=Issues]").shouldHave(text("Issues")));
    }

    @Test
    @DisplayName("Check annotation")
    public void annotatedStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Steps steps = new Steps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.checkIssue();
    }
}