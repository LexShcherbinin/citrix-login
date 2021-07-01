package citrixlogin.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class StoreFrontPage {
    public static void uncoverActions() {
        $(By.xpath("//div[@class='storeapp-action-link-sprite']")).click();
    }

    public static void clickButton(final String buttonName) {
        Selenide.$(By.xpath("//div[@class='appDetails-actions-item']//div[.='" + buttonName + "']")).click();
    }

    public static void clickTab(final String buttonName) {
        $(By.xpath("//a[@id='desktopsBtn']//span[.='" + buttonName + "']")).click();
    }
}
