package wikipedia.helpers;

import org.aeonbits.owner.ConfigFactory;
import wikipedia.drivers.Config;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    public static String videoUrl(final String sessionId) {
        Config config = ConfigFactory.create(Config.class, System.getProperties());
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(config.getBrowserstackUser(), config.getBrowserstackKey())
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}