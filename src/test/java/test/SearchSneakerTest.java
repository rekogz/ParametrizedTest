package test;

import components.ConfigurationBase;
import components.SneakerPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class SearchSneakerTest extends ConfigurationBase {
    SneakerPage sneakerPage = new SneakerPage();

    @Tag("SMOKE")
    @CsvSource(value = {
            "Nike | 45",
            "Adidas | 43"
    }, delimiter = '|')
    @ParameterizedTest(name = "Поиск кроссовок бренда {0} размером {1}")
    void SearchSneakersCsvSource(String selectBrand, int sizeSneaker) {
        sneakerPage.openPage()
                .brandSelection(selectBrand)
                .sizeSelection(sizeSneaker);
    }

    @Tag("SMOKE")
    @CsvFileSource(resources = "/files/InformationAboutSneakers.csv")
    @ParameterizedTest(name = "Поиск кроссовок бренда {0} размером {1}")
    void SearchSneakersCsvFileSource(String selectBrand, int sizeSneaker) {
        sneakerPage.openPage()
                .brandSelection(selectBrand)
                .sizeSelection(sizeSneaker);
    }

    static Stream<Arguments> SearchSneakersMethodSource() {
        return Stream.of(
                Arguments.of("Nike", 41),
                Arguments.of("Adidas", 45));
    }

    @Tag("SMOKE")
    @MethodSource
    @ParameterizedTest(name = "Поиск кроссовок бренда {0} размером {1}")
    void SearchSneakersMethodSource(String selectBrand, int sizeSneaker) {
        sneakerPage.openPage()
                .brandSelection(selectBrand)
                .sizeSelection(sizeSneaker);
    }

    @Tag("SMOKE")
    @ValueSource(strings = {"Reebok", "Baden"})
    @ParameterizedTest(name = "Поиск кроссовок бренда {0}")
    void SearchSneakersValueSource(String selectBrand) {
        sneakerPage.openPage()
                .brandSelection(selectBrand);
    }
}
