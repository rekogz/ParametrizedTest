package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SuccessFullTest {
    @Test
    void ChooseBoots() {
        open("https://www.wildberries.ru/");
        // Открыть категории
        $("button.nav-element__burger").click();
        // Выбрать категорию: Обувь
        $(".menu-burger__main-list-link--629").click();
        // Выбрать в подкатегории: Мужская
        $$(".j-menu-item").get(3).click();
        // Нажать на "Бренд"
        $$(".dropdown-filter").get(4).click();
        // Выбрать бренд
        $(".filter__list li");
        $$(".checkbox-with-text__text").findBy(text("Nike")).click();
        // Нажать на кнопку "Готово"
        $(".filter-btn").find(byText("Готово")).click();
        // Нажать на "Размер"
        $$(".dropdown-filter").get(7).click();
        // Выбрать размер "44"
        $(".j-search-filter").setValue("41");
        // Подтвердить размер "44"
        $$(".filter__list li");
        $$(".checkbox-with-text").findBy(Condition.text("41")).click();
        // Нажать на кнопку "Готово"
        sleep(5000);
    }
}
