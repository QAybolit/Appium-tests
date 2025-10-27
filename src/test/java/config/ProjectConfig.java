package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:project.properties"
})
public interface ProjectConfig extends Config {

    ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class);

    @Key("platform.name")
    String platformName();

    @Key("platform.version")
    String platformVersion();

    @Key("device.name")
    String deviceName();

    @Key("automation.name")
    String automationName();

    @Key("appium.url")
    String appiumUrl();

    @Key("timeout")
    long timeout();

    @Key("vk.video.app")
    String vkVideoApp();

    @Key("vk.video.app.package")
    String vkVideoAppPackage();

    @Key("vk.video.app.activity")
    String vkVideoAppActivity();

    @Key("free.vpn.app")
    String freeVpnApp();

    @Key("free.vpn.app.package")
    String freeVpnAppPackage();

    @Key("free.vpn.app.activity")
    String freeVpnAppActivity();
}
