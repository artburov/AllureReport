package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.GitIssuePage;

import static com.codeborne.selenide.Condition.text;

@DisplayName("Suite with Selenide")
public class SelenideIssueTests {
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
    @DisplayName("Selenide with logger auto-steps")
    void gitSelenideIssueTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        page.openGit(BASE_URL);
        page.gitSearch().setValue(REPOSITORY).pressEnter();
        page.gitLink(REPOSITORY_LINK).click();
        page.gitIssues().click();
        page.openSpecifiedIssue().click();
        page.verifyIssueTitle().shouldHave(text(ISSUE_TITLE));
    }
}