package citrixlogin;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.io.FilenameUtils;

public class DesktopRunner {

    public static void openFile() {
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
        List<String> list = Arrays.stream(Objects.requireNonNull(file.list()))
            .filter(doc -> FilenameUtils.getName(doc).contains(".ica"))
            .collect(Collectors.toList());

        return list.get(0);
    }

}
