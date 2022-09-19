package framework.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
    
    public static String getCurrentTimeAsString() {
        return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    }
}
