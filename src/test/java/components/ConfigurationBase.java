package components;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class ConfigurationBase {

    @BeforeAll
    static void Configuration() {
        Configuration.pageLoadStrategy = "normal";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.wildberries.ru";
    }
}
