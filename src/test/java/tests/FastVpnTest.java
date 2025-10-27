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

@Owner("Dina Kholomkina")
public class FastVpnTest {

//    @BeforeEach
//    public void initDriver() {
//        AndroidDriver driver = AndroidDriverProvider.createDriverForFreeVpn();
//        WebDriverRunner.setWebDriver(driver);
//        SelenideLogger.addListener("Allure", new AllureSelenide());
//    }
//
//    @Test
//    @DisplayName("")
//    public void test() {
//        // ....
//    }
//
//    @AfterEach
//    public void tearDown() {
//        closeWebDriver();
//    }
}
