package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.GitIssuePage;

import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

@DisplayName("Suite with lambda steps")
public class LambdaIssueTests {

    private final String BASE_URL = "https://github.com/";
    private final static String REPOSITORY = "Allure2";
    private final static String REPOSITORY_LINK = "allure-framework/allure2";
    private final static String ISSUE_TITLE = "Can't install Allure with Scoop";

    private GitIssuePage page = new GitIssuePage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    @Owner("aburov")
    @Feature("Practice with lambda steps")
    @Story("Using lambda")
    @DisplayName("Lambda in usage")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("236-ST")
    @Link(name = "IssueURL", url = "https://myissue.com")
    void gitLambdaTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        step("Open the main GIT page", (x) -> {
            x.parameter("url", BASE_URL);

            page.openGit(BASE_URL);
        });
        step("Look for the repository", (x) -> {
            x.parameter("repositoryName", REPOSITORY);
            page.gitSearch().setValue(REPOSITORY).pressEnter();
        });
        step("Open the needed repository", (x) -> {
            x.parameter("repositoryLink", REPOSITORY_LINK);
            page.gitLink(REPOSITORY_LINK).click();
        });
        step("In a specified repository click on the 'Issue' tab", () -> {
            page.gitIssues().click();
        });
        step("Look for the specified issue", () -> {
            page.openSpecifiedIssue().click();
        });
        step("Verify that title relates to the specified issue", () -> {
            page.verifyIssueTitle().shouldHave(text(ISSUE_TITLE));
        });
    }
}
