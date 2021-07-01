package citrixlogin.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.$;

public class ReceiverPage {
    public static void clickButton(final String buttonName) {
        Selenide.sleep(1000);
        $(By.xpath("//a[.='" + buttonName + "']")).click();

        Selenide.sleep(1000);
        try {
            new Robot().keyPress(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
