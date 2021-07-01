package citrixlogin.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public static void sendKeys(final String fieldName, final String value) {
        $(By.xpath("//label[.='" + fieldName + " :']/..//following-sibling::div//input")).sendKeys(value);
    }

    public static void clickButton(final String buttonName) {
        $(By.xpath("//a[.='" + buttonName + "']")).click();
    }
}
