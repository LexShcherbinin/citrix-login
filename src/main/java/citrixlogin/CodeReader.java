package citrixlogin;

import static citrixlogin.ConfigLoader.CONFIG;

import java.util.Scanner;

public class CodeReader {

    public static String getCode() {
        System.out.print("Enter code:");

        Scanner scanner = new Scanner(System.in);
        String citrixPassword = scanner.nextLine();
        scanner.close();

        return CONFIG.getString("citrixPrePassword") + citrixPassword;
    }

}
