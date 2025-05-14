package qa.guru.allure.Steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps {

    @Step("Open main page GitHub")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Found repository {repository}")
    public void searchForRepository(String repository) {
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue(repository).pressEnter();
    }

    @Step("Click to link repository {repository}")
    public void clickOnRepositoryLink(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Check enable Issue with number {issue}")
    public void checkIssue() {
        $("[data-content=Issues]").shouldHave(text("Issues"));
    }
}