package mobile.valid;

public class ValidMobileProperties {
    public static final double MIN_PRICE = 150;

    public static final double MIN_DIAG_SCREEN_SIZE = 2;
    public static final double MAX_DIAG_SCREEN_SIZE = 10;

    public static final double MIN_PPI = 200;
    public static final double MAX_PPI = 600;

    public static final double MIN_RAM = 64;
    public static final double MAX_RAM = 1024;

    public static boolean isValidDiagonalScreenSize(double value) {
        return (value >= MIN_DIAG_SCREEN_SIZE) && (value <= MAX_DIAG_SCREEN_SIZE);
    }

    public static boolean isValidPpi(double value) {
        return (value >= MIN_PPI) && (value <= MAX_PPI);
    }

    public static boolean isValidRam(double value) {
        return (value >= MIN_RAM) && (value <= MAX_RAM) && ((value%64) == 0) && (value%64 % 2 == 0) ;
    }

    public static boolean isValidPrice(double value) {
        return value >= MIN_PRICE ;
    }
}
