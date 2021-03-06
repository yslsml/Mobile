package mobile.valid;

import mobile.entity.Brand;

public class ValidMobileProperties {
    public static final double MIN_PRICE = 150;

    public static final double MIN_DIAG_SCREEN_SIZE = 2;
    public static final double MAX_DIAG_SCREEN_SIZE = 10;

    public static final double MIN_PPI = 200;
    public static final double MAX_PPI = 600;

    public static final int MIN_RAM = 64;
    public static final int MAX_RAM = 1024;

    public static boolean isValidDiagonalScreenSize(double value) {
        return (value >= MIN_DIAG_SCREEN_SIZE) && (value <= MAX_DIAG_SCREEN_SIZE);
    }

    public static boolean isValidPpi(double value) {
        return (value >= MIN_PPI) && (value <= MAX_PPI);
    }

    public static boolean isValidRam(int value) {
        return (value >= MIN_RAM) && (value <= MAX_RAM) && ((value%64) == 0) ;
    }

    public static boolean isValidPrice(double value) {
        return value >= MIN_PRICE ;
    }

    public static boolean isValidMobileBrand(String brandStr){
        Brand[] brands = Brand.values();
        for(Brand brand : brands){
            if(brand.toString().equalsIgnoreCase(brandStr)){
                return true;
            }
        }
        return false;
    }
}
