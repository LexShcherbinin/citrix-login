package citrixlogin.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;

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
