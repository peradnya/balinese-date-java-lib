package net.peradnya.balinesedate;

import java.util.GregorianCalendar;

public final class Utils {
    
    public static String toTitleCase(String text) {
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '_') {
                arr[i] = ' ';
            } else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                if (i >= 1 && arr[i - 1] != ' ') {
                    arr[i] = Character.toLowerCase(arr[i]);
                } 
            }
        }

        return new String(arr);
    }

    public static int getDeltaDay(GregorianCalendar a, GregorianCalendar b) {
        long timeA   = a.getTimeInMillis();
        long timeB   = b.getTimeInMillis();

        return (int) ((timeB - timeA) / (1000 * 60 * 60 * 24));
    }

    public static int mod(int a, int b) {
        return ((a % b) + b) % b;
    }

}
