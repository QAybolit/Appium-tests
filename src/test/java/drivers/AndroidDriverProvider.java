package drivers;

import static config.ProjectConfig.projectConfig;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidDriverProvider {

    public static AndroidDriver createDriverForVkVideo() {
        UiAutomator2Options options = getBaseOptions()
                .setApp(getFileAbsolutePath(projectConfig.vkVideoApp()))
                .setAppPackage(projectConfig.vkVideoAppPackage())
                .setAppActivity(projectConfig.vkVideoAppActivity());

        return new AndroidDriver(getServerUrl(), options);
    }

    public static AndroidDriver createDriverForFreeVpn() {
        UiAutomator2Options options = getBaseOptions()
                .setApp(getFileAbsolutePath(projectConfig.freeVpnApp()))
                .setAppPackage(projectConfig.freeVpnAppPackage())
                .setAppActivity(projectConfig.freeVpnAppActivity());

        return new AndroidDriver(getServerUrl(), options);
    }

    private static UiAutomator2Options getBaseOptions() {
        return new UiAutomator2Options()
                .setPlatformName(projectConfig.platformName())
                .setPlatformVersion(projectConfig.platformVersion())
                .setDeviceName(projectConfig.deviceName())
                .setAutomationName(projectConfig.automationName());
    }

    private static URL getServerUrl() {
        try {
            return new URI(projectConfig.appiumUrl()).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFileAbsolutePath(String fileName) {
        ClassLoader classLoader = AndroidDriverProvider.class.getClassLoader();
        return Objects.requireNonNull(classLoader.getResource(fileName)).getPath();
    }
}
