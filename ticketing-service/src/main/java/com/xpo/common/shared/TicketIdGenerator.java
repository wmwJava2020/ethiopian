package com.xpo.common.shared;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class TicketIdGenerator {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("ddMMyy");

    public static String generate(String prefix, long sequence) {
        String date    = LocalDate.now().format(FORMATTER);
        String millis  = String.valueOf(System.currentTimeMillis());
        String lastSix = millis.substring(millis.length() - 6);
        String seq     = String.format("%04d", sequence);
        return String.format("%s-%s-%s-%s", prefix, date, lastSix, seq);
    }
}
