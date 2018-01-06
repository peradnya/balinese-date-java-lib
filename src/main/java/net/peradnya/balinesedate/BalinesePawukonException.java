package net.peradnya.balinesedate;

public class BalinesePawukonException extends Exception {
    
    private static final long serialVersionUID = 1003L;

    public static final String INVALID_DAY_IN_YEAR = "Invalid day in year value. Value need in between 0 - 209.";

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