package steps;

import io.qameta.allure.Step;
import pages.GitIssuePage;

import static com.codeborne.selenide.Condition.text;

public class WebSteps {

    private GitIssuePage page = new GitIssuePage();

    @Step("Open the main GIT page")
    public void openMainPage(String url) {
        page.openGit(url);
    }

    @Step("Look for the repository {repository}")
    public void searchRepository(String repository) {
        page.gitSearch().setValue(repository).pressEnter();
    }

    @Step("Open the needed repository {repositoryLink}")
    public void openNeededRepository(String repositoryLink) {
        page.gitLink(repositoryLink).click();
    }

    @Step("In a specified repository click on the 'Issue' tab")
    public void openIssues() {
        page.gitIssues().click();
    }

    @Step("Look for the specified issue")
    public void openSpecifiedIssue() {
        page.openSpecifiedIssue().click();
    }

    @Step("Verify that title '{issueTitle}' - relates to the specified issue")
    public void verifySpecifiedIssue(String issueTitle) {
        page.verifyIssueTitle().shouldHave(text(issueTitle));
    }
}