package citrixlogin.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

public class CitrixPage {
    public static void clickButton(final String buttonName) {
        $(By.xpath("//a[@id='protocolhandler-detect-alreadyInstalledLink'][.='" + buttonName + "']"))
            .waitUntil(Condition.visible, 5000)
            .click();
    }
}
