package peradnya.libs.balinesedate;

import java.util.GregorianCalendar;

public final class BalineseDateUtil {

    private static final long DAY_IN_MS = 86400000L;
    
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
        // try to fix precision error
        double deltaMillis = (double) (b.getTimeInMillis() - a.getTimeInMillis());
        return (int) Math.ceil(deltaMillis / DAY_IN_MS);
    }

    public static int mod(int a, int b) {
        // try to fix negative mod
        return ((a % b) + b) % b;
    }

}
