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
import pages.vkvideo.VkVideoMainPage;

@Owner("Dina Kholomkina")
public class VkVideoTest extends BaseTest {

    @BeforeEach
    public void initDriver() {
        AndroidDriver driver = AndroidDriverProvider.createDriverForVkVideo();
        WebDriverRunner.setWebDriver(driver);
        SelenideLogger.addListener("Allure", new AllureSelenide());
    }

    @Test
    @DisplayName("Проверка воспроизведения видео")
    public void checkFirstVideoTest() {
        VkVideoMainPage mainPage = new VkVideoMainPage();

        mainPage.closeBannerIfExist()
                .skipFastLoginIfExist()
                .selectFirstVideo()
                .checkVideoIsDisplayed()
                .selectNextVideo()
                .checkVideoNotDisplayed();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
