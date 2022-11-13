package wikipedia.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    void searchTest() {

        step("Close onboarding screen", Selenide::back);

        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Test
    void searchWithByTextLocatorTest() {

        step("Close onboarding screen", Selenide::back);

        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Test
    void gettingStartedTest() {

        step("Check first onboarding screen", () -> {
            mainPage.addLangContainerClick()
                    .languageTitleCheckText("English")
                    .navigateUpClick();
        });

        step("Check second onboarding screen", () -> {
            mainPage.continueButtonClick()
                    .primaryTextViewCheck("New ways to explore");
        });

        step("Check third onboarding screen", () -> {
            mainPage.continueButtonClick()
                    .primaryTextViewCheck("Reading lists with sync");
        });

        step("Check fourth onboarding screen", () -> {

            step("Check 'data usage' switch is enabled", () -> {
                mainPage.continueButtonClick()
                        .switchViewCheckIsEnabled();
            });

            step("Switch off 'data usage'", () -> {
                mainPage.switchViewClick();
            });
        });

        step("Check main page", () -> {

            step("Check 'CUSTOMIZE' text on button", () -> {
                mainPage.getStartedButtonClick()
                        .customizeButtonCheckText("CUSTOMIZE");
            });

            step("Click on 'Got it' button", () -> {
                mainPage.gotItButtonClick();
            });

            step("Check 'Featured article' header", () -> {
                mainPage.headerTitleTextCheck("Featured article");
            });
        });
    }
}
