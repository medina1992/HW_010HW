package qa.guru.allure.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver()
                .clearDriverCache()
                .clearResolutionCache()
                .setup();
    }
}