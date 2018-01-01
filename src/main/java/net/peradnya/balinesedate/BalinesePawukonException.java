package net.peradnya.balinesedate;

public class BalinesePawukonException extends Exception {
    
    private static final long serialVersionUID = 1003L;

    public static final String INVALID_DAY_OF_YEAR = "Invalid day of year value. Value need between 0 - 209.";

    public BalinesePawukonException(String text) {
        super(text);
    }

    public BalinesePawukonException(Throwable throwable) {
        super(throwable);
    }

    public BalinesePawukonException(String text, Throwable throwable) {
        super(text, throwable);
    }
}