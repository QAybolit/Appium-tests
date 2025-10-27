package tests;

import static config.ProjectConfig.projectConfig;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import drivers.AndroidDriverProvider;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = AndroidDriverProvider.class.getName();
        Configuration.timeout = projectConfig.timeout();
        Configuration.pollingInterval = 500;
        Configuration.browserSize = null;
    }
}
