package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitIssuePage {

    public void openGit(String url) {
        open(url);
    }

    public SelenideElement gitSearch() {
        return $(".header-search-input");
    }

    public SelenideElement gitLink(String link) {
        return $(By.linkText(link));
    }

    public SelenideElement gitIssues() {
        return $("[data-content='Issues']");
    }

    public SelenideElement openSpecifiedIssue() {
        return $("#issue_1198_link");
    }

    public SelenideElement verifyIssueTitle() {
        return $(".gh-header-show");
    }
}
