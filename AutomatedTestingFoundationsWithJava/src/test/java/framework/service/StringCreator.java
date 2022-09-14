package framework.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringCreator {
    public static String getCurrentTimeAsString() {
        return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    }
}
