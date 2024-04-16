package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SneakerPage {
    private final SelenideElement
            setBrandSelection = $(".filter__list li"),
            setSizeSneaker = $$(".dropdown-filter").get(7);

    public SneakerPage openPage() {
        open("https://www.wildberries.ru/");
        sleep(2000);
        $("button.nav-element__burger").click();
        $(".menu-burger__main-list-link--629").click();
        $$(".j-menu-item").get(3).click();
        $$(".dropdown-filter").get(4).click();
        return this;
    }

    public SneakerPage brandSelection(String selectBrand) {
        setBrandSelection.click();
        $$(".checkbox-with-text__text").findBy(text(selectBrand)).click();
        $(".filter-btn").find(byText("Готово")).click();
        return this;
    }

    public SneakerPage sizeSelection(int sizeSneaker) {
        setSizeSneaker.click();
        $(".j-search-filter").setValue(String.valueOf(sizeSneaker));
        $$(".filter__list li");
        $$(".checkbox-with-text").findBy(Condition.text(String.valueOf(sizeSneaker))).click();
        $(".filter-btn").find(byText("Готово")).click();
        return this;
    }
}
