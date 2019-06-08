package top.zeimao77.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatUtil {

    public static final DateTimeFormatter standardDateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");

    public static final DateTimeFormatter standardTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static final DateTimeFormatter standardDateFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");

    public static String standardDateTime(LocalDateTime dateTime) {
        return standardDateTimeFormatter.format(dateTime);
    }

    public static String standardTime(LocalDateTime dateTime) {
        return standardTimeFormatter.format(dateTime);
    }

    public static String nowTime() {
        return standardTime(LocalDateTime.now());
    }

    public static String standardDate(LocalDateTime dateTime) {
        return standardDateFormatter.format(dateTime);
    }

    public static String nowDate() {
        return standardDate(LocalDateTime.now());
    }

}
