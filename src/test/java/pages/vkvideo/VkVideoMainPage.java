package pages.vkvideo;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class VkVideoMainPage {

    private final SelenideElement closeBannerBtn = $(AppiumBy.id("close_btn_left"));
    private final SelenideElement skipBtn = $(AppiumBy.id("fast_login_tertiary_btn"));

    private final ElementsCollection videos = $$(AppiumBy.id("video_display"));


    @Step("Закрыть баннер, если он отображается")
    public VkVideoMainPage closeBannerIfExist() {
        if (this.closeBannerBtn.is(visible, Duration.ofMillis(10000))) {
            this.closeBannerBtn.click();
        }
        return this;
    }

    @Step("Пропустить логин, если он отображается")
    public VkVideoMainPage skipFastLoginIfExist() {
        if (this.skipBtn.is(visible, Duration.ofMillis(2000))) {
            this.skipBtn.click();
        }
        return this;
    }

    @Step("Выбрать первое видео из списка")
    public VideoPage selectFirstVideo() {
        this.videos.first().click();
        return new VideoPage();
    }
}
