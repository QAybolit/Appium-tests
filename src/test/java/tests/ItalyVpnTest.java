package tests;

import static com.codeborne.selenide.Selenide.closeWebDriver;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import drivers.AndroidDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import pages.italyvpn.SplashVpnPage;

@Owner("Dina Kholomkina")
public class ItalyVpnTest extends BaseTest {

    @BeforeEach
    public void initDriver() {
        AndroidDriver driver = AndroidDriverProvider.createDriverForItalyVpn();
        WebDriverRunner.setWebDriver(driver);
        SelenideLogger.addListener("Allure", new AllureSelenide());
    }

    @Test
    @DisplayName("Проверка подключения к Italy VPN")
    public void italyVpnTest() {
        SplashVpnPage splashVpnPage = new SplashVpnPage();
        String vpnStatus = "Connecting...";

        splashVpnPage.openSplashVpnPage()
                .acceptAgreement()
                .checkVpnMainPage()
                .clickStartVpnConnectionBtn()
                .checkVpnStatus(vpnStatus);
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
