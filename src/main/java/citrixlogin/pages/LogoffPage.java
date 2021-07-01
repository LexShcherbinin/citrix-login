package citrixlogin.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogoffPage {
    public static void clickButton(final String buttonName) {
        $(By.xpath("//input[@value='" + buttonName + "']")).click();
    }
}
