package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Formatter {

    public static String formatForDisplay(String text) {
        try {
            BigDecimal value = new BigDecimal(text);

            value = value.setScale(2, RoundingMode.HALF_UP);

            String string = value.toPlainString();
            String[] separated = string.split("\\.");
            String beforeDot = separated[0];
            String afterDot = separated[1];

            boolean negative = beforeDot.startsWith("-");
            String intAbs = negative ? beforeDot.substring(1) : beforeDot;
            if (intAbs.length() > 5) {
                return "BŁĄD";
            }

            int absIntPart = Integer.parseInt(intAbs);
            String formattedAbs = String.format("%05d", absIntPart);
            String formattedIntPart = (negative ? "-" : "") + formattedAbs;

            return formattedIntPart + "." + afterDot;

        } catch (Exception e) {
            return "BŁĄD";
        }
    }
}