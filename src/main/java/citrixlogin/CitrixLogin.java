package citrixlogin;

import citrixlogin.pages.CitrixPage;
import citrixlogin.pages.LoginPage;
import citrixlogin.pages.LogoffPage;
import citrixlogin.pages.ReceiverPage;
import citrixlogin.pages.StoreFrontPage;
import com.codeborne.selenide.Selenide;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.apache.commons.io.FilenameUtils;

public class CitrixLogin {
    public static void main(String[] args) {
        Config config = ConfigFactory.load();
        String login = config.getString("login");
        String password = config.getString("password");
        String citrixPassword = getCode();

        Selenide.open(config.getString("url"));

        LogoffPage.clickButton("Log On");

        LoginPage.sendKeys("User name", login);
        LoginPage.sendKeys("Password", password);
        LoginPage.sendKeys("Password 2", citrixPassword);
        LoginPage.clickButton("Log On");

//        ReceiverPage.clickButton("Обнаружить Receiver");
        ReceiverPage.clickButton("Обнаружить приложение Citrix Workspace");

        CitrixPage.clickButton("Уже установлено");

        StoreFrontPage.clickTab("Рабочие столы");
        StoreFrontPage.uncoverActions();
        StoreFrontPage.clickButton("Открыть");

        Selenide.sleep(5000);

        openFile();
    }

    private static String getCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter code:" );
        String citrixPassword = scanner.nextLine();
        scanner.close();

        return "" + citrixPassword;
    }

    private static void openFile() {
        String fileName = getFileName();
        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.open(new File("C:\\Users\\User\\Downloads\\" + fileName));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileName() {
        File file = new File("C:\\Users\\User\\Downloads");
        List<String> list = Arrays.stream(file.list())
            .filter(doc -> FilenameUtils.getName(doc).contains(".ica"))
            .collect(Collectors.toList());

        return list.get(0);
    }

}