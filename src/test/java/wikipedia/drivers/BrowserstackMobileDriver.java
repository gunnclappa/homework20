package wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static Config config = ConfigFactory.create(Config.class, System.getProperties());

    @Override
    public final WebDriver createDriver(final Capabilities capabilities) {

        MutableCapabilities mutableCapabilities = new MutableCapabilities();

        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", config.getBrowserstackUser());
        mutableCapabilities.setCapability("browserstack.key", config.getBrowserstackKey());
        mutableCapabilities.setCapability("appUrl", config.getAppUrl());
        mutableCapabilities.setCapability("device", config.getDevice());
        mutableCapabilities.setCapability("os_version", config.getOsVersion());
        mutableCapabilities.setCapability("project", config.getProject());
        mutableCapabilities.setCapability("build", config.getBuild());
        mutableCapabilities.setCapability("name", config.getName());
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(config.getRemoteUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}