package test;

import components.ConfigurationBase;
import components.SneakerPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Tag("SMOKE")
    @CsvFileSource(resources = "/files/InformationAboutSneakers.csv")
    @ParameterizedTest(name = "Поиск кроссовок бренда {0} размером {1}")
    void SearchSneakers(String selectBrand, int sizeSneaker) {
        sneakerPage.openPage()
                .brandSelection(selectBrand)
                .sizeSelection(sizeSneaker);
    }
}
