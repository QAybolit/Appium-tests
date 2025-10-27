package pages.vkvideo;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import utils.NetworkConnectionUtils;

public class VideoPage {

    private final SelenideElement video = $(AppiumBy.id("video_display"));
    private final SelenideElement seekBar = $(AppiumBy.id("seek_bar"));
    private final SelenideElement videoButtonsView = $(AppiumBy.id("video_buttons_view"));
    private final SelenideElement currentProgress = $(AppiumBy.id("current_progress"));

    private final SelenideElement similarVideo = $(AppiumBy.id("similar_video"));

    private final SelenideElement mainVideoLoader = $(AppiumBy.id("progress_view"));
    private final SelenideElement similarVideoShimmer = $(AppiumBy.id("video_skeleton"));


    @Step("Проверить, что открывшееся видео воспроизводится")
    public VideoPage checkVideoIsDisplayed() {
        this.video.click();
        this.seekBar.shouldBe(visible);
        this.videoButtonsView.shouldBe(visible);
        this.currentProgress.shouldBe(visible);
        return this;
    }

    @Step("Выбрать следующее видео из списка")
    public VideoPage selectNextVideo() {
        this.similarVideo.shouldBe(exist).click();
        return this;
    }

    @Step("Проверить, что открывшееся видео не воспроизводится (эмуляция отсутсвия интеренета)")
    public VideoPage checkVideoNotDisplayed() {
        NetworkConnectionUtils.disableNetworkConnection();

        this.mainVideoLoader.shouldBe(visible);
        this.similarVideoShimmer.shouldBe(visible);

        this.video.click();
        this.seekBar.shouldNotBe(visible);
        this.videoButtonsView.shouldNotBe(visible);
        this.currentProgress.shouldNotBe(visible);

        NetworkConnectionUtils.enableNetworkConnection();
        return this;
    }

}
