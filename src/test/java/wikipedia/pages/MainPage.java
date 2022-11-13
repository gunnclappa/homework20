package wikipedia.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public final class MainPage {

    private final SelenideElement addLangContainer = $(AppiumBy.id("org.wikipedia.alpha:id/addLangContainer"));
    private final SelenideElement languageTitle = $(AppiumBy.id("org.wikipedia.alpha:id/wiki_language_title"));
    private final SelenideElement navigateUp = $(AppiumBy.accessibilityId("Navigate up"));
    private final SelenideElement continueButton =
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));
    private final SelenideElement primaryTextView = $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"));
    private final SelenideElement switchView = $(AppiumBy.id("org.wikipedia.alpha:id/switchView"));
    private final SelenideElement getStartedButton = $(AppiumBy.id("fragment_onboarding_done_button"));
    private final SelenideElement customizeButton =
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_action_positive"));
    private final SelenideElement gotItButton =
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_action_negative"));
    private final SelenideElement headerTitle = $(AppiumBy.id("org.wikipedia.alpha:id/view_card_header_title"));

    public MainPage addLangContainerClick() {
        addLangContainer.click();

        return this;
    }

    public MainPage languageTitleCheckText(final String value) {
        languageTitle.shouldHave(text(value));

        return this;
    }

    public MainPage navigateUpClick() {
        navigateUp.click();

        return this;
    }

    public MainPage continueButtonClick() {
        continueButton.click();

        return this;
    }

    public MainPage primaryTextViewCheck(final String value) {
        primaryTextView.shouldHave(text(value));

        return this;
    }

    public MainPage switchViewCheckIsEnabled() {
        switchView.shouldBe(enabled);

        return this;
    }

    public MainPage switchViewClick() {
        switchView.click();

        return this;
    }

    public MainPage getStartedButtonClick() {
        getStartedButton.click();

        return this;
    }

    public MainPage customizeButtonCheckText(final String value) {
        customizeButton.shouldHave(text(value));

        return this;
    }

    public MainPage gotItButtonClick() {
        gotItButton.click();

        return this;
    }

    public MainPage headerTitleTextCheck(final String value) {
        headerTitle.shouldHave(text(value));

        return this;
    }

}
