package pages.italyvpn;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import static io.appium.java_client.AppiumBy.androidUIAutomator;

import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class SplashVpnPage {

    private final SelenideElement italyLogo = $(AppiumBy.id("ImageView1"));
    private final SelenideElement fetchingConnectionText = $(AppiumBy.id("TextView1"));
    private final SelenideElement agreement = $(androidUIAutomator("new UiSelector().textMatches(\"Consent\")"));

    @Step("Проверить, что загрузилась стартовая страница приложения")
    public SplashVpnPage openSplashVpnPage() {
        this.italyLogo.shouldBe(visible);
        this.fetchingConnectionText.shouldBe(visible);
        return this;
    }

    @Step("Подтвердить согласие на обработку персональных данных")
    public ItalyVpnMainPage acceptAgreement() {
        this.agreement.shouldBe(visible).click();
        return new ItalyVpnMainPage();
    }
}
