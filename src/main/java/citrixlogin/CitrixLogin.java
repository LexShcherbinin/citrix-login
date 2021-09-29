package citrixlogin;

import static citrixlogin.ConfigLoader.CONFIG;

import citrixlogin.pages.CitrixPage;
import citrixlogin.pages.LoginPage;
import citrixlogin.pages.LogoffPage;
import citrixlogin.pages.ReceiverPage;
import citrixlogin.pages.StoreFrontPage;
import com.codeborne.selenide.Selenide;

public class CitrixLogin {

    public static void main(String[] args) {
        String url = CONFIG.getString("url");
        String login = CONFIG.getString("login");
        String password = CONFIG.getString("password");
        String citrixPassword = CodeReader.getCode();

        Selenide.open(url);
        LogoffPage.clickButton("Log On");
        LoginPage.sendKeys("User name", login);
        LoginPage.sendKeys("Password", password);
        LoginPage.sendKeys("Password 2", citrixPassword);
        LoginPage.clickButton("Log On");

        ReceiverPage.clickButton("Обнаружить приложение Citrix Workspace");
        CitrixPage.clickButton("Уже установлено");
        StoreFrontPage.clickTab("Рабочие столы");
        StoreFrontPage.uncoverActions();
        StoreFrontPage.clickButton("Открыть");

        Selenide.sleep(5000);
        DesktopRunner.openFile();
    }

}