package pages.italyvpn;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class ItalyVpnMainPage {

    private final SelenideElement tabBar = $(AppiumBy.id("tabBar"));
    private final SelenideElement turnOnVpnBtn = $(AppiumBy.id("lottie"));
    private final SelenideElement connectionStatus = $(AppiumBy.id("TextView4"));

    @Step("Проверить, что стартовая страница для подключения к VPN загрузилась")
    public ItalyVpnMainPage checkVpnMainPage() {
        this.tabBar.shouldBe(visible);
        this.turnOnVpnBtn.shouldBe(visible, clickable);
        this.connectionStatus.shouldBe(visible).shouldHave(text("Disconnected!"));
        return this;
    }

    @Step("Нажать на кнопку включения VPN")
    public ItalyVpnMainPage clickStartVpnConnectionBtn() {
        this.turnOnVpnBtn.click();
        return this;
    }

    @Step("Проверить статус подключения")
    public ItalyVpnMainPage checkVpnStatus(String status) {
        this.connectionStatus.shouldBe(visible).shouldHave(text(status));
        return this;
    }

}
