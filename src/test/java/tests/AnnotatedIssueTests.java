package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.WebSteps;

@DisplayName("Suite with annotated steps")
public class AnnotatedIssueTests {

    private final String BASE_URL = "https://github.com/";
    private final static String REPOSITORY = "Allure2";
    private final static String REPOSITORY_LINK = "allure-framework/allure2";
    private final static String ISSUE_TITLE = "Can't install Allure with Scoop";


    private WebSteps steps = new WebSteps();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    @Owner("aburov")
    @Feature("Practice with annotation steps")
    @Story("Using annotation")
    @DisplayName("Annotation in usage")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "BaseURL", url = "https://mygit.com")
    public void gitAnnotatedTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        steps.openMainPage(BASE_URL);
        steps.searchRepository(REPOSITORY);
        steps.openNeededRepository(REPOSITORY_LINK);
        steps.openIssues();
        steps.openSpecifiedIssue();
        steps.verifySpecifiedIssue(ISSUE_TITLE);
    }
}