package utils;

import com.codeborne.selenide.WebDriverRunner;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;

public class NetworkConnectionUtils {

    public static void disableNetworkConnection() {
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        driver.setConnection(new ConnectionStateBuilder().withAirplaneModeEnabled().build());
    }

    public static void enableNetworkConnection() {
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        driver.setConnection(new ConnectionStateBuilder().withAirplaneModeDisabled()
                .withDataEnabled()
                .withWiFiEnabled()
                .build());
    }
}
