package pages.vpnapp;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumBy;

public class VpnAppMainPage {

    private final SelenideElement connectionLabel = $(AppiumBy.xpath("//android.widget.TextView[@text='Determining the best server ...']"));
    private final SelenideElement turnOnVpnBtn = $(AppiumBy.xpath("//android.widget.TextView[@text='ON']"));

    int[][] closeBtnCoordinates = {
            {1000, 268},
            {1000, 240},
            {1023, 1140}
    };

    private final SelenideElement connectingLabel = $(AppiumBy.xpath("//android.widget.TextView[@text='Connecting to the server...']"));
    private final SelenideElement connectionResultBtn = $(AppiumBy.xpath(""));
//    private final SelenideElement connectionStatus = $(AppiumBy.id())


}
