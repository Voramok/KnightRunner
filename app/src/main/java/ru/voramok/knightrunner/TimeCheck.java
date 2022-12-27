package ru.voramok.knightrunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface TimeCheck {

    default long startCheck() {
        LocalDateTime now0 = LocalDateTime.now();
        ZonedDateTime zonedDateTime0 = ZonedDateTime.of(now0, ZoneId.systemDefault());
        return zonedDateTime0.toInstant().toEpochMilli();
    }

    default long endCheck(long date0) {
        LocalDateTime now1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(now1, ZoneId.systemDefault());
        long date1 = zonedDateTime1.toInstant().toEpochMilli();
        return date1 - date0;
    }

}
