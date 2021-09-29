package citrixlogin;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigLoader {

    public static final Config CONFIG = ConfigFactory.load();

    public static String getValue(String name) {
        return CONFIG.getString(name);
    }

}
