package test;

import components.ConfigurationBase;
import components.SneakerPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchSneakerTest extends ConfigurationBase {
    SneakerPage sneakerPage = new SneakerPage();

    @Tag("SMOKE")
    @CsvSource(value = {
            "Nike | 45",
            "Adidas | 43"
    }, delimiter = '|')
    @ParameterizedTest(name = "Поиск кроссовок бренда {0} размером {1}")
    void SearchSneaker(String selectBrand, int sizeSneaker) {
        sneakerPage.openPage()
                .brandSelection(selectBrand)
                .sizeSelection(sizeSneaker);
    }
}