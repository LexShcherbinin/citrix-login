package citrixlogin.pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class LogoffPage {
    public static void clickButton(final String buttonName) {
        $(By.xpath("//input[@value='" + buttonName + "']")).click();
    }
}
