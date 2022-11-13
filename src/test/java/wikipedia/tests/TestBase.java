package wikipedia.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import wikipedia.drivers.BrowserstackMobileDriver;
import wikipedia.drivers.LocalMobileDriver;
import wikipedia.helpers.Attach;
import wikipedia.pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static wikipedia.helpers.Attach.sessionId;

public class TestBase {

    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setup() throws Exception {
        String host = System.getProperty("env");
        switch (host) {
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                Configuration.browserSize = null;
                break;
            case "local":
                Configuration.browser = LocalMobileDriver.class.getName();
                Configuration.browserSize = null;
                break;
            case "real":
                Configuration.browser = LocalMobileDriver.class.getName();
                Configuration.browserSize = null;
                break;
            default:
                throw new Exception("Wrong env");
        }
    }

    @BeforeEach
    public final void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());

        open();
    }

    @AfterEach
    public final void afterEach() {
        if (System.getProperty("env").equals("browserstack")) {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            String sessionId = sessionId();
            closeWebDriver();
            Attach.video(sessionId);
        } else {
            closeWebDriver();
        }
    }
}